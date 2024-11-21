package com.demo.employeemanagement.model;

import com.demo.employeemanagement.exceptions.EmployeeDaoException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDao {
    static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee("John Doe", "E001", "IT", "Developer", 50000, "john.doe@example.com"));
        employees.add(new Employee("Jane Smith", "E002", "HR", "Manager", 60000, "jane.smith@example.com"));
        employees.add(new Employee("Bob Johnson", "E003", "Finance", "Accountant", 55000, "bob.johnson@example.com"));
        employees.add(new Employee("Alice Brown", "E004", "Marketing", "Coordinator", 45000, "alice.brown@example.com"));
        employees.add(new Employee("Charlie Davis", "E005", "Sales", "Representative", 48000, "charlie.davis@example.com"));
    }
    public List<Employee> getAllEmployees() {
        return employees;
    }
    public Employee getEmployeeById(String empId) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeId().equals(empId))
                .findFirst()
                .orElseThrow(()-> new EmployeeDaoException.EmployeeNotFoundException("Employee Not Found with Id "+empId+" !"));
    }
    public String addEmployee(Employee employee) {
        if(employeeExists(employee)) {
            throw new EmployeeDaoException.EmployeeAlreadyExistsException("Employee Already Exists!");
        }
        int nextEmployeeIdNumber = employees.size() + 1;
        String nextEmployeeId = "E" + String.format("%03d", nextEmployeeIdNumber);
        employee.setEmployeeId(nextEmployeeId);
        employees.add(employee);
        return "Employee Successfully Added!";
    }
    //logic to check if the details already exist in the database
    public boolean employeeExists(Employee employee) {
        return employees.stream()
                .anyMatch(existingEmployee -> {
                    return existingEmployee.getName().equals(employee.getName()) &&
                            existingEmployee.getEmail().equals(employee.getEmail());
                });
    }
}

