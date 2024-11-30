package com.demo.employeemanagement.controller;

import com.demo.employeemanagement.model.Employee;
import com.demo.employeemanagement.model.EmployeeDao;
import jakarta.validation.Valid;
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
    public String addEmployee(@Valid @RequestBody Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @PutMapping("/employees/update/{empId}")
    public String updateEmployee(@PathVariable String empId, @Valid @RequestBody Employee updatedEmployee) {
        return  employeeDao.updateEmployee(empId, updatedEmployee);
    }

    @DeleteMapping("/employees/delete/{empId}")
    public String deleteEmployee(@PathVariable String empId) {
        return employeeDao.deleteEmployee(empId);
    }


}
