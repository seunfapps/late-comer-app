package com.seunfapps.latecomer.entities;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class Employee extends Base{
    private String name;
    private String email;
    private String address;
    private double amountOwed;

    public Employee(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
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

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

}
