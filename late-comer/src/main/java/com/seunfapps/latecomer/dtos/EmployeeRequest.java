package com.seunfapps.latecomer.dtos;

import org.joda.time.LocalTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmployeeRequest {
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    private String address;
    private double amountOwed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
