package ru.plotnikov.advboard.model;

public class AdvertisementRequest {
    public int categoryId;
    private String title;
    private String description;

    public AdvertisementRequest(int categoryId, String title, String description) {
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
