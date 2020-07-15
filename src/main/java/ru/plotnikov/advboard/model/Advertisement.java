package ru.plotnikov.advboard.model;

import java.sql.Timestamp;

public class Advertisement {
    private int id;
    private String title;
    private String description;
    private Timestamp addDateTime;

    public Advertisement(int id, String title, String description, Timestamp addDateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.addDateTime = addDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getAddDateTime() {
        return addDateTime;
    }

    public void setAddDateTime(Timestamp addDateTime) {
        this.addDateTime = addDateTime;
    }

    public String toString() {
        return "{ id: " + this.id + ", title: " + this.title + ", description: " + this.description + ", addTime: " + this.addDateTime.toString() + "}";
    }
}
