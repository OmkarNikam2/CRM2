package com.example.first.controller;

import com.example.first.model.Employee;
import com.example.first.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

     @Autowired
    private EmployeeRepository employeeRepository;


    //get employee
     @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }


    //build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    //build get employee by id using REST API



}
