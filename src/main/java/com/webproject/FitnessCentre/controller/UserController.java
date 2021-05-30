package com.webproject.FitnessCentre.controller;


import com.webproject.FitnessCentre.entity.User;
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
        this.userService.save(user);
        return "redirect:/";
    }
    @GetMapping("/login")
    public String pre_login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login.html";
    }


//    @GetMapping("/employees/{id}")
//    public String getEmployee(@PathVariable("id") Long id, Model model) {

    @GetMapping("/login-attempt")
    public String post_login(@ModelAttribute User user) {
        List<User> users = userService.findAll();
        for (User myUser : users) {
            if(user.getUsername().equals(myUser.getUsername())){
                if(user.getPassword().equals(myUser.getPassword())){
                    System.out.println(myUser.getRole());
                    if(myUser.getRole().equals("MEMBER"))
                        return  "redirect:/member";
                    else if(myUser.getRole().equals("TRAINER"))
                        return  "redirect:/trainer";
                    else
                        return  "redirect:/user";
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


