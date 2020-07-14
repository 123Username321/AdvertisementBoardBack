package ru.plotnikov.advboard.model;

public class AdvertisementRequest {
    private String title;
    private String description;
    private String addTime;

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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String toPrint() {
        return "{\n\ttitle: " + this.title + ",\n\tdescription: " + this.description + ",\n\taddTime: " + this.addTime + "\n}";
    }
}
