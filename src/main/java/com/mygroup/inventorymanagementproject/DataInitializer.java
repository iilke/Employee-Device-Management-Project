//This is a class used for testing during development process

/*package com.mygroup.inventorymanagementproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {

        Employee employee = new Employee();
        employee.setTcno("9876543210");
        employee.setName("Ilke");
        employee.setSurname("Dz");
        employee.setLandingOnJobDate(java.sql.Date.valueOf("2024-07-01"));
        employee.setQuitingJobDate(Date.valueOf("2024-08-01"));


        Employee savedEmployee = employeeService.addEmployee(employee);

        System.out.println("Employee added: " + savedEmployee);
    }
}*/
