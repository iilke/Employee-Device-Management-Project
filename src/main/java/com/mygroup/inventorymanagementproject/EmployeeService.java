package com.mygroup.inventorymanagementproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void removeEmployee(String tcno) {
        employeeRepository.deleteById(tcno);
    }

    public Employee editEmployee(String tcno, Employee updatedEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(tcno);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setName(updatedEmployee.getName());
            employee.setSurname(updatedEmployee.getSurname());
            employee.setLandingOnJobDate(updatedEmployee.getLandingOnJobDate());
            employee.setQuitingJobDate(updatedEmployee.getQuitingJobDate());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String tcno) {
        return employeeRepository.findById(tcno).orElse(null);
    }
}
