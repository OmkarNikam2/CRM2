package com.example.first;

import com.example.first.model.Employee;
import com.example.first.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);

	}


	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee();
		employee.setFirstName("omkar");
		employee.setLastName("nikam");
		employee.setEmailId("omkar@gmail.com");
		employeeRepository.save(employee);


	}
}
