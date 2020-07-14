package ru.plotnikov.advboard.model;

import java.sql.Timestamp;

public class AdvertisementRequest {
    private String title;
    private String description;

    public AdvertisementRequest(String title, String description) {
        this.title = title;
        this.description = description;
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

    public String toPrint() {
        return "{\n\ttitle: " + this.title + ",\n\tdescription: " + this.description + ",\n}";
    }
}
