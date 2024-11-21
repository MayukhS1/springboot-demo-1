package com.demo.employeemanagement.exceptions;

import java.util.Date;

public class EmployeeExceptionResponse {
    private String errorMessage, description;
    private Date timeStamp;

    public EmployeeExceptionResponse(String errorMessage, String description, Date timeStamp) {
        this.errorMessage = errorMessage;
        this.description = description;
        this.timeStamp = timeStamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
