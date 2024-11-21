package com.demo.employeemanagement.controller;

import com.demo.employeemanagement.model.Employee;
import com.demo.employeemanagement.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeDao.getAllEmployees();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable String empId) {
        return employeeDao.getEmployeeById(empId);
    }

    @PostMapping("/employees/add")
    public String addEmployee(@RequestBody Employee employee) {
        return employeeDao.addEmployee(employee);
    }

//    @PutMapping("/employees/update/{empId}")


}
