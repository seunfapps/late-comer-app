package com.seunfapps.latecomer.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EmployeeAttendance extends Base{
    private String name;
    private String arrivalTime;

    public EmployeeAttendance(String name, String arrivalTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

}
