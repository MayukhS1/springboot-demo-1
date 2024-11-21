package com.demo.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        HttpStatus status = statusHandler(ex);
        EmployeeExceptionResponse exceptionResponse = new EmployeeExceptionResponse(
                ex.getMessage(),
                request.getDescription(false),
                new Date()
                );
        return new ResponseEntity<Object>(exceptionResponse, status);
    }
    HttpStatus statusHandler(Exception ex) {
        if(ex instanceof EmployeeDaoException.EmployeeNotFoundException) {
            return HttpStatus.NOT_FOUND;
        } else if (ex instanceof EmployeeDaoException.EmployeeAlreadyExistsException) {
            return HttpStatus.CONFLICT;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
