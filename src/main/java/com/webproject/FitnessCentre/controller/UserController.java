package com.webproject.FitnessCentre.controller;

import com.webproject.FitnessCentre.entity.Member;
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

//    @GetMapping("/login")
//    public String login() { return "login.html"; }

//    @GetMapping("/signup")
//    public String signup() { return "signup.html"; }

    @PostMapping("/signup-member")
    public String signupUser(@ModelAttribute Member member) {
        this.userService.save(member);
        return "redirect:/";
    }
//    @PostMapping("/login-user")
//    public String loginUser(@ModelAttribute User user) {
//        this.userService.save(user);
//        return "redirect:/";
//    }
    @GetMapping(value = "/signup")
    public String displaySignup(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "signup.html";
    }
    @GetMapping(value = "/login")
    public String displayLogin(Model model) {
        Member user = new Member();
        model.addAttribute("user", user);
        return "login.html";
    }


//    @GetMapping("/users")
//    public String getUsers(Model model) {
//        List<User> employeeList = this.userService.findAll();
//        model.addAttribute("users", employeeList);
//        return "users.html";
//    }
//
//    @GetMapping("/users")
//    public String getTrainings(Model model) {
//        List<User> userList = this.userService.findAll();
//        model.addAttribute("trainings", userList);
//        return "trainings.html";
//    }
//
//    @GetMapping("/users/{id}")
//    public String getEmployee(@PathVariable("id") Long id, Model model) {
//        User user = this.userService.findOne(id);
//        model.addAttribute("user", user);
//        return "user.html";
//    }
//
//    @GetMapping("/signup")
//    public String signup(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "signup.html";
//    }
//    @GetMapping("/signin")
//    public String login(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "signin.html";
//    }
//
//    @PostMapping("/save-user")
//    public String saveEmployee(@ModelAttribute User user) {
//        this.userService.save(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteEmployee(@PathVariable Long id) {
//        this.userService.delete(id);
//        return "redirect:/users";
//    }
}
