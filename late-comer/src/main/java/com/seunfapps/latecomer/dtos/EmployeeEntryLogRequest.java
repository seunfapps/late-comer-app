package com.seunfapps.latecomer.dtos;

import org.joda.time.DateTime;

import javax.validation.constraints.NotBlank;

public class EmployeeEntryLogRequest {
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private String address;

    private DateTime arrivalTime;

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

    public DateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(DateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
