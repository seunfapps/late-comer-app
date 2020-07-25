package com.seunfapps.latecomer.entities;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EmployeeAttendance extends Base{
    private String name;
    private String email;
    private String address;
    private String arrivalTime;
    private double amountOwed;

    public EmployeeAttendance(String name, String arrivalTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

}
