package com.demo.employeemanagement.model;

public class Employee {
    private String name;
    private String employeeId;
    private String department;
    private String designation;
    private double salary;
    private String email;

    public Employee(String name, String employeeId, String department, String designation, double salary, String email) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
