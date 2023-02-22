package com.example.first.repository;

import com.example.first.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //all crud db methods
}
