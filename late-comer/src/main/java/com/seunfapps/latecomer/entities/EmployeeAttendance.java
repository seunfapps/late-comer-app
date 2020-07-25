package com.seunfapps.latecomer.entities;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EmployeeAttendance extends Base{
    private String name;
    private String email;
    private String address;
    private LocalTime arrivalTime;
    private double amountOwed;

    public EmployeeAttendance(String name, LocalTime arrivalTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.createdOn = new DateTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

}
