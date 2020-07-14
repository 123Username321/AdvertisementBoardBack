package ru.plotnikov.advboard.model;

import java.sql.Timestamp;

public class Advertisement {
    int id;
    String title;
    String description;
    Timestamp addTime;

    public Advertisement(int id, String title, String description, Timestamp addTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.addTime = addTime;
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

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }
}
