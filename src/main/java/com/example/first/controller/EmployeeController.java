package com.example.first.controller;

import com.example.first.exception.ResourceNotFoundException;
import com.example.first.model.Employee;
import com.example.first.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("{id}")
     public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
         Employee employee= employeeRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("employee not exist with id:"+ id));
         return ResponseEntity.ok(employee);
     }


     //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
         Employee updateEmployee = employeeRepository.findById(id)
                 .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" +id));

         updateEmployee.setFirstName(employeeDetails.getFirstName());
         updateEmployee.setLastName(employeeDetails.getEmailId());
         updateEmployee.setEmailId(employeeDetails.getEmailId());

         employeeRepository.save(updateEmployee);

         return ResponseEntity.ok(updateEmployee);

    }

}
