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

    @GetMapping("/")
    public String home() { return "home.html"; }
    @GetMapping("/user")
    public String userPage() { return "user.html"; }
    @GetMapping("/member")
    public String memberPage(){ return "member.html"; }
    @GetMapping("/trainer")
    public String trainerPage() { return "trainer.html"; }


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
        List<Training> listProducts = trainingService.allTrainings();
//        List<Training> listProducts = trainingService.allUnassignedTrainings(member.getAssignedTrainings());
        model.addAttribute("list", listProducts);
        model.addAttribute("appointments", appointmentService.findAll());
        model.addAttribute("member", member);

        return "trainings.html";
    }


    @RequestMapping("/admin")
    public String getTrainers(Model model) {
        List<Trainer> trainers = trainerService.findAll();
        model.addAttribute("list", trainers);
        return "admin.html";
    }

    @GetMapping("/allow/{id}")
    public String allowTrainer(@PathVariable("id") Long id) {
        Trainer trainer = this.trainerService.findOne(id);
        trainer.setAllowed(true);
        this.trainerService.save(trainer);
        return "redirect:/admin";
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

    @GetMapping("/admin/fitness/data")
    public String pre_fitness_data(Model model) {
        Fitness fitness = new Fitness();
        model.addAttribute("fitness", fitness);
        return "fitness_creator_data.html";
    }

    @GetMapping("/admin/fitness/{id}/trainers")
    public String pre_fitness_data_trainers(@PathVariable("id") Long id, Model model) {
        Fitness fitness = this.fitnessService.findOne(id);
        List<Trainer> trainerList = this.trainerService.findAllAllowed();
        model.addAttribute("list", trainerList);
        model.addAttribute("fitness",fitness);
        return "fitness_creator_trainers.html";
    }

    @GetMapping("/admin/fitness/{id}/trainers/{trainer_id}")
    public String pre_fitness_data_trainers_added(@PathVariable("id") Long id, @PathVariable("trainer_id") Long trainer_id) {
        Trainer trainer = this.trainerService.findOne(trainer_id);
        Fitness fitness = this.fitnessService.findOne(id);
        Set<Trainer> tempTrainers = fitness.getTrainers();
        tempTrainers.add(trainer);
        trainer.setFitness(fitness);
        this.fitnessService.save(fitness);
        this.trainerService.save(trainer);
        return "redirect:/admin/fitness/"+id+"/trainers";
    }

    @PostMapping("/admin/fitness/data")
    public String post_fitness_data(@ModelAttribute Fitness fitness) {
        this.fitnessService.save(fitness);
        return "redirect:/admin/fitness/"+fitness.getId()+"/trainers";
    }

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
                                return "redirect:/trainer";
                        } else {
                            return "redirect:/admin";
                        }
                    }
                }
            }
        }
        return  "redirect:/login";
    }

}


