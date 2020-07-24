package com.seunfapps.latecomer.entities;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

public class Base {
    @Id
    private String id;
    private DateTime createdOn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getCreateOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTime dateCreated) {
        this.createdOn = dateCreated;
    }
}
