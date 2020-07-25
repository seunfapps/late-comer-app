package com.seunfapps.latecomer.dtos;

import org.joda.time.LocalTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmployeeRequest {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    private String address;

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

}
