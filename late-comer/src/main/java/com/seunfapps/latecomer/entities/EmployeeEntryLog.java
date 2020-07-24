package com.seunfapps.latecomer.entities;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class EmployeeEntryLog extends Base{
    private String name;
    private String email;
    private String address;
    private LocalTime arrivalTime;
    private double amountOwed;

    public EmployeeEntryLog(String name, String email, String address, LocalTime arrivalTime) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.arrivalTime = arrivalTime;
        this.createdOn = new DateTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }
}
