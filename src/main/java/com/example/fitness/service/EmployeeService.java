package com.example.fitness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitness.entity.Employee;
import com.example.fitness.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;
	
	public Employee findOne(Long id) {
        Employee employee = this.employeeRepository.getOne(id);
        return employee;
    }
	
    public List<Employee> findAll() {
        List<Employee> employees = this.employeeRepository.findAll();
        return employees;
    }
    
    public Employee save(Employee employee) {
    	return this.employeeRepository.save(employee);
    }

    public void delete(Long id) {
	    this.employeeRepository.deleteById(id);
    }

}
