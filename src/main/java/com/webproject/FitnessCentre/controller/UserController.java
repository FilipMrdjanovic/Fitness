package com.webproject.FitnessCentre.controller;


import com.webproject.FitnessCentre.entity.Administrator;
import com.webproject.FitnessCentre.entity.Member;
import com.webproject.FitnessCentre.entity.Trainer;
import com.webproject.FitnessCentre.entity.User;
import com.webproject.FitnessCentre.service.AdminService;
import com.webproject.FitnessCentre.service.MemberService;
import com.webproject.FitnessCentre.service.TrainerService;
import com.webproject.FitnessCentre.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/")
    public String home() { return "home.html"; }
    @GetMapping("/user")
    public String userPage() { return "user.html"; }
    @GetMapping("/member")
    public String memberPage() { return "member.html"; }
    @GetMapping("/trainer")
    public String trainerPage() { return "trainer.html"; }
    @GetMapping("/admin")
    public String adminPage() { return "admin.html"; }

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
                    if(myUser.getRole().equals("MEMBER")){
                        return  "redirect:/member";
                    }
                    else if(myUser.getRole().equals("TRAINER")){
                        return  "redirect:/trainer";
                    }
                    else{
                        return  "redirect:/admin";
                    }
                }
            }
        }
        return  "redirect:/";
    }








//        @PostMapping("/signup")
//        public String registerUser(@RequestBody User newUser) {
//            List<User> users = userService.findAll();
//            for (User user : users) {
//                if (user.equals(newUser)) {
//                    System.out.println("User Already exists!");
//                    return "home.html";
//                }
//            }
//            userService.save(newUser);
//            return "member.html";
//        }
//        @PostMapping("/login")
//        public String loginUser(@RequestBody User user) {
//
//                if (this.userService.checkProfile(user.getUsername(), user.getPassword())) {
////                    userService.save(user);
//                    return "member.html";
//                }
//
//            return "home.html";
//        }

//        @PostMapping("/logout")
//        public String logUserOut(@Validated @RequestBody User user) {
//            List<User> users = userService.findAll();
//            for (User other : users) {
//                if (other.equals(user)) {
//                    user.setLoggedIn(false);
//                    userService.save(user);
//                    return Status.SUCCESS;
//                }
//            }
//            return Status.FAILURE;
//        }

    }


