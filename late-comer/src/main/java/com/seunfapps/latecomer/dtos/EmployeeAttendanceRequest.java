package com.seunfapps.latecomer.dtos;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import javax.validation.constraints.NotNull;

public class EmployeeAttendanceRequest {
    @NotNull
    private String employeeId;
    @NotNull
    private String arrivalTime;


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


}
