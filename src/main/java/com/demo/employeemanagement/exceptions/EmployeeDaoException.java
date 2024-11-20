package com.demo.employeemanagement.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

public class EmployeeDaoException extends RuntimeException {
    public EmployeeDaoException(String s) {
        super(s);
    }

    @ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
    public static class EmployeeNotFoundException extends RuntimeException {
        public EmployeeNotFoundException(String s) {
            super(s);
        }
    }
    @ResponseStatus(value = org.springframework.http.HttpStatus.CONFLICT)
    public static class EmployeeAlreadyExistsException extends RuntimeException {
        public EmployeeAlreadyExistsException(String s) {
            super(s);
        }
    }
}
