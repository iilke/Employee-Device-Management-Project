package com.mygroup.inventorymanagementproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{tcno}")
    public void removeEmployee(@PathVariable String tcno) {
        employeeService.removeEmployee(tcno);
    }

    @PutMapping("/{tcno}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String tcno, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.editEmployee(tcno, updatedEmployee);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{tcno}")
    public Employee getEmployeeById(@PathVariable String tcno) {
        return employeeService.getEmployeeById(tcno);
    }
}
