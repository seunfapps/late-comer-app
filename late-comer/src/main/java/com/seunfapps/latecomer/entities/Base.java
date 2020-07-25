package com.seunfapps.latecomer.entities;

import org.springframework.data.annotation.Id;

public class Base {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
