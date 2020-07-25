package com.seunfapps.latecomer.dtos;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeAttendanceRequest {
    @NotNull
    private String employeeId;
    @NotNull
    private LocalTime arrivalTime;


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


}
