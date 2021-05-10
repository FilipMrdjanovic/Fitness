package com.example.fitness.controller;

import com.example.fitness.entity.Employee;
import com.example.fitness.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Klasa je anotirana sa @Controller što treba da naznači Springu da je klasa
 * Spring Bean i da treba da bude u nadležnosti Spring kontejnera.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String welcome() {
        return "home.html";
    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<Employee> employeeList = this.employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "employees.html";
    }

    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable("id") Long id, Model model) {
    	Employee employee = this.employeeService.findOne(id);
    	model.addAttribute("employee", employee);
    	return "employee.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String addEmployee(Model model) {
    	Employee employee = new Employee();
    	model.addAttribute("employee", employee);
    	return "signup.html";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute Employee employee) {
    	this.employeeService.save(employee);
    	return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        this.employeeService.delete(id);
        return "redirect:/employees";
    }


    
}
