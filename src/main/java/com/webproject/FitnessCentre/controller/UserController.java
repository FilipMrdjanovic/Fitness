package com.webproject.FitnessCentre.controller;


import com.webproject.FitnessCentre.entity.*;
import com.webproject.FitnessCentre.repository.TrainingRepository;
import com.webproject.FitnessCentre.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private TrainingService trainingService;
    @Autowired
    private FitnessService fitnessService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private HallService hallService;

    public Long adminId;

    //==========================HOME=================================

    @GetMapping("/")
    public String home() { return "home.html"; }

    //==========================SIGNUP=================================

    @GetMapping("/signup")
    public String pre_signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup.html";
    }

    @PostMapping("/signup")
    public String post_signup(@ModelAttribute User user) {
        if(user.getRole().equals("MEMBER")){
            Member member = new Member();
            member.setId(user.getId());
            member.setUsername(user.getUsername());
            member.setPassword(user.getPassword());
            member.setFirstName(user.getFirstName());
            member.setLastName(user.getLastName());
            member.setEmail(user.getEmail());
            member.setRole(user.getRole());
            member.setBirthDate(user.getBirthDate());
            member.setMobileNumber(user.getMobileNumber());
            member.setActive(user.getActive());
            this.memberService.save(member);
        }
        else if(user.getRole().equals("TRAINER")){
            Trainer trainer = new Trainer();
            trainer.setId(user.getId());
            trainer.setUsername(user.getUsername());
            trainer.setPassword(user.getPassword());
            trainer.setFirstName(user.getFirstName());
            trainer.setLastName(user.getLastName());
            trainer.setEmail(user.getEmail());
            trainer.setRole(user.getRole());
            trainer.setBirthDate(user.getBirthDate());
            trainer.setMobileNumber(user.getMobileNumber());
            trainer.setActive(user.getActive());
            trainer.setAllowed(false);
            trainer.setGrade(5);
            this.trainerService.save(trainer);
        }
        else{
            Administrator administrator = new Administrator();
            administrator.setId(user.getId());
            administrator.setUsername(user.getUsername());
            administrator.setPassword(user.getPassword());
            administrator.setFirstName(user.getFirstName());
            administrator.setLastName(user.getLastName());
            administrator.setEmail(user.getEmail());
            administrator.setRole(user.getRole());
            administrator.setBirthDate(user.getBirthDate());
            administrator.setMobileNumber(user.getMobileNumber());
            administrator.setActive(user.getActive());
            this.adminService.save(administrator);
        }
        return "redirect:/";
    }

    //==========================LOGIN=================================

    @GetMapping("/login")
    public String pre_login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login.html";
    }

    @GetMapping("/login-attempt")
    public String post_login(@ModelAttribute User user) {
        List<User> users = userService.findAll();
        for (User myUser : users) {
            if(user.getUsername().equals(myUser.getUsername())){
                if(user.getPassword().equals(myUser.getPassword())){
                    if(myUser.getActive()) {
                        if (myUser.getRole().equals("MEMBER")) {
//                            return "redirect:/member/"+myUser.getId()+"/trainings";
                            return "redirect:/member/"+myUser.getId();
                        } else if (myUser.getRole().equals("TRAINER")) {
                            Trainer trainer = this.trainerService.findOne(myUser.getId());
                            if (!trainer.getAllowed())
                                return "redirect:/login";
                            else
                                return "redirect:/trainer/"+myUser.getId();
                        } else {
                            return "redirect:/admin/"+myUser.getId();
                        }
                    }
                }
            }
        }
        return  "redirect:/login";
    }

    //==========================MEMBER=================================

    @RequestMapping("/member/{id}")
    public String member(Model model, @PathVariable("id") Long id) {

        Member member = this.memberService.findOne(id);
        model.addAttribute("member", member);
        return "member.html";
    }

    @RequestMapping("/member/{id}/trainings")
    public String getTrainings(Model model, @PathVariable("id") Long id) {
        Member member = memberService.findOne(id);
        appointmentService.Create(trainingService.allTrainings());

        List<Training> listProducts = trainingService.allUnassignedTrainings(member);
//        List<Training> listProducts = trainingService.allTrainings();

        model.addAttribute("list", listProducts);
        model.addAttribute("appointments", appointmentService.findAll());
        model.addAttribute("member", member);

        return "trainings.html";
    }

    @RequestMapping("/member/{id}/appointments")
    public String getAppliedTrainings(Model model, @PathVariable("id") Long id) {
        Member member = memberService.findOne(id);
        appointmentService.Create(trainingService.allTrainings());

        List<Training> listProducts = trainingService.allSignedTrainings(member);

        model.addAttribute("list", listProducts);
        model.addAttribute("appointments", appointmentService.findAll());
        model.addAttribute("member", member);

        return "appointments.html";
    }

    @RequestMapping("/member/{id}/completed")
    public String getCompletedTrainings(Model model, @PathVariable("id") Long id) {
        Member member = memberService.findOne(id);
        appointmentService.Create(trainingService.allTrainings());

        List<Training> listProducts = trainingService.allCompletedTrainings(member);

        model.addAttribute("list", listProducts);
        model.addAttribute("appointments", appointmentService.findAll());
        model.addAttribute("member", member);

        return "completed_trainings.html";
    }

    @GetMapping("/reserve/{trainingId}/{id}")
    public String reserveTraining(@PathVariable("trainingId") Long trainingId, @PathVariable("id") Long id) {
        Member member = this.memberService.findOne(id);
        Set<Appointment> temp = member.getAssignedTrainings();
        temp.add(appointmentService.findOneByTraining(trainingId));
        member.setAssignedTrainings(temp);
        memberService.save(member);
        return "redirect:/member/"+id+"/trainings";
    }

    @GetMapping("/remove/{trainingId}/{id}")
    public String removeTraining(@PathVariable("trainingId") Long trainingId, @PathVariable("id") Long id) {

        Member member = this.memberService.findOne(id);
        Set<Appointment> temp = member.getAssignedTrainings();
        temp.remove(appointmentService.findOneByTraining(trainingId));
        member.setAssignedTrainings(temp);
        memberService.save(member);
        return "redirect:/member/"+id+"/appointments";
    }

    //==========================ADMIN=================================

    @RequestMapping("/admin/{admin_id}")
    public String getTrainers(@PathVariable("admin_id") Long admin_id, Model model) {
        List<Trainer> trainers = trainerService.findAll();
        model.addAttribute("list", trainers);
        model.addAttribute("id", admin_id);
        return "admin.html";
    }

    @GetMapping("/admin/{admin_id}/fitness/{id}/trainers")
    public String pre_fitness_data_trainers(@PathVariable("id") Long id, @PathVariable("admin_id") Long admin_id, Model model) {
        Fitness fitness = this.fitnessService.findOne(id);
        List<Trainer> trainerList = this.trainerService.findAllAllowed();
        model.addAttribute("list", trainerList);
        model.addAttribute("fitness",fitness);
        model.addAttribute("id", adminService.findOne(admin_id));
        return "fitness_creator_trainers.html";
    }

    @GetMapping("/admin/{admin_id}/fitness/{id}/trainers/{trainer_id}")
    public String pre_fitness_data_trainers_added(@PathVariable("id") Long id, @PathVariable("trainer_id") Long trainer_id, @PathVariable("admin_id") Long admin_id) {
        Trainer trainer = this.trainerService.findOne(trainer_id);
        Fitness fitness = this.fitnessService.findOne(id);
        Set<Trainer> tempTrainers = fitness.getTrainers();
        tempTrainers.add(trainer);
        trainer.setFitness(fitness);
        this.fitnessService.save(fitness);
        this.trainerService.save(trainer);
        return "redirect:/admin/" + admin_id + "/fitness/"+id+"/trainers";
    }

    @GetMapping("/admin/{admin_id}/fitness/{id}/halls")
    public String pre_fitness_data_halls(@PathVariable("id") Long id, @PathVariable("admin_id") Long admin_id, Model model) {
        Fitness fitness = this.fitnessService.findOne(id);
        List<Hall> hallList = this.hallService.findAllNullFitness();
        model.addAttribute("list", hallList);
        model.addAttribute("fitness",fitness);
        model.addAttribute("id", adminService.findOne(admin_id));
        return "fitness_creator_halls.html";
    }

    @GetMapping("/admin/{admin_id}/fitness/{id}/halls/{hall_id}")
    public String pre_fitness_data_halls_added(@PathVariable("id") Long id, @PathVariable("hall_id") Long hall_id, @PathVariable("admin_id") Long admin_id) {
        Hall hall = this.hallService.findOne(hall_id);
        Fitness fitness = this.fitnessService.findOne(id);
        Set<Hall> tempHalls = fitness.getHalls();
        tempHalls.add(hall);
        hall.setFitness(fitness);
        this.fitnessService.save(fitness);
        this.hallService.save(hall);
        return "redirect:/admin/" + admin_id + "/fitness/"+id+"/halls";
    }

    @GetMapping("/admin/{admin_id}/fitness/{id}/halls/edit")
    public String pre_fitness_data_halls_edit(@PathVariable("id") Long id, @PathVariable("admin_id") Long admin_id, Model model) {
        Fitness fitness = this.fitnessService.findOne(id);
        List<Hall> hallList = this.hallService.findAllFitness(id);
        model.addAttribute("list", hallList);
        model.addAttribute("fitness",fitness);
        model.addAttribute("id", adminService.findOne(admin_id));
        return "fitness_creator_halls_edit.html";
    }

    @GetMapping("/admin/{admin_id}/fitness/{id}/halls/edit/{hall_id}")
    public String pre_fitness_data_halls_edit_page(@PathVariable("id") Long id, @PathVariable("admin_id") Long admin_id, @PathVariable("hall_id") Long hall_id, Model model) {
        Hall hall = hallService.findOne(hall_id);
        model.addAttribute("hall", hall);
        return "halls_edit.html";
    }

    @GetMapping("/admin/{admin_id}/fitness/{id}/halls/delete/{hall_id}")
    public String pre_fitness_data_halls_delete(@PathVariable("id") Long id, @PathVariable("admin_id") Long admin_id, @PathVariable("hall_id") Long hall_id) {
        this.hallService.delete(hall_id);
        return "redirect:/admin/" + admin_id + "/fitness/" + id + "/halls/edit";
    }

    @PostMapping("/admin/fitness/data")
    public String post_fitness_data(@ModelAttribute Fitness fitness, Model model) {
        this.fitnessService.save(fitness);
        return "redirect:/admin/" + adminId +"/fitness/"+fitness.getId()+"/trainers";
    }

    @GetMapping("/admin/{admin_id}/fitness/data")
    public String pre_fitness_data(@PathVariable("admin_id") Long admin_id, Model model) {
        Fitness fitness = new Fitness();
        Administrator administrator = this.adminService.findOne(admin_id);
        model.addAttribute("fitness", fitness);
        model.addAttribute("admin", administrator);
        adminId = admin_id;
        return "fitness_creator_data.html";
    }

    @GetMapping("/admin/{admin_id}/fitness")
    public String listFitness(@PathVariable("admin_id") Long admin_id, Model model) {
        List<Fitness> list = fitnessService.allFitnessCentres();
        Administrator administrator = this.adminService.findOne(admin_id);
        model.addAttribute("list", list);
        model.addAttribute("admin", administrator);
        return "fitness.html";
    }

    @GetMapping("/admin/{admin_id}/trainers")
    public String listTrainers(@PathVariable("admin_id") Long admin_id, Model model) {
        List<Trainer> list = trainerService.allTrainers();
        Administrator administrator = this.adminService.findOne(admin_id);
        model.addAttribute("list", list);
        model.addAttribute("admin", administrator);
        return "trainers.html";
    }

    @GetMapping("/allow/{id}/{trainer_id}")
    public String allowTrainer(@PathVariable("id") Long id, @PathVariable("trainer_id") Long trainer_id) {
        Trainer trainer = this.trainerService.findOne(trainer_id);
        trainer.setAllowed(true);
        this.trainerService.save(trainer);
        return "redirect:/admin/" + id;
    }

    @GetMapping("/admin/{admin_id}/edit/{id}")
    public String editFitnessCentre(@PathVariable("admin_id") Long admin_id, @PathVariable("id") Long id, Model model) {
        Fitness fitness = fitnessService.findOne(id);
        model.addAttribute("fitness", fitness);
        return "fitness_edit.html";
    }

    @GetMapping("/admin/{admin_id}/delete/{id}")
    public String deleteFitnessCentre(@PathVariable("admin_id") Long admin_id, @PathVariable("id") Long id) {
        fitnessService.delete(id);
        return "redirect:/admin/" + admin_id + "/fitness";
    }

    @GetMapping("/admin/{admin_id}/delete/trainers/{id}")
    public String deleteTrainer(@PathVariable("admin_id") Long admin_id, @PathVariable("id") Long id) {
        trainerService.delete(id);
        return "redirect:/admin/" + admin_id + "/trainers";
    }

    @PostMapping("/admin/{id}/fitness/{fitness_id}/edit")
    public String postEditFitnessCentre(@PathVariable("id") Long id, @PathVariable("fitness_id") Long fitness_id, @ModelAttribute Fitness fitness) {
        this.fitnessService.save(fitness);
        Administrator administrator = adminService.findOne(id);
        return "redirect:/admin/"+administrator.getId() + "/fitness/"+fitness.getId()+"/trainers";
    }

    @GetMapping("/admin/{admin_id}/register")
    public String pre_admin_create_trainer(@PathVariable("admin_id") Long admin_id, Model model) {
        Trainer trainer = new Trainer();
        Administrator administrator = this.adminService.findOne(admin_id);
        model.addAttribute("trainer", trainer);
        model.addAttribute("admin", administrator);
        adminId = admin_id;
        return "admin_signup_trainer.html";
    }

    @PostMapping("/admin/create")
    public String post_admin_create_trainer(@ModelAttribute Trainer trainer, Model model) {
        trainer.setRole("TRAINER");
        trainer.setAllowed(true);
        trainer.setActive(true);
        this.trainerService.save(trainer);
        return "redirect:/admin/" + adminId;
    }

    @PostMapping("/admin/{id}/edit/change")
    public String changeFitness(@PathVariable("id") Long id, @ModelAttribute Fitness fitness) {
        this.fitnessService.save(fitness);
        return "redirect:/admin/" + id + "/fitness";
    }

    @PostMapping("/admin/{admin_id}/fitness/{fitness_id}/halls/edit/{hall_id}/change")
    public String changeHall(@PathVariable("admin_id") Long admin_id, @PathVariable("fitness_id") Long fitness_id, @PathVariable("hall_id") Long hall_id, @ModelAttribute Hall hall) {
        Hall tempHall = hallService.findOne(hall_id);
        tempHall.setCapacity(hall.getCapacity());
        hallService.save(tempHall);
        return "redirect:/admin/" + admin_id + "/fitness/" + fitness_id+ "/trainers";
    }


    //==========================TRAINER=================================

    @GetMapping("/trainer/{id}")
    public String trainerPage() { return "trainer.html"; }



}


