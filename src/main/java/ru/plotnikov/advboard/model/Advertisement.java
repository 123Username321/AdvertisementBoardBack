package ru.plotnikov.advboard.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    @Column(name = "add_date")
    private Timestamp addDateTime;

    public Advertisement() { }

    public Advertisement(String title, String description) {
        this.id = 0;
        this.title = title;
        this.description = description;
        this.addDateTime = Timestamp.valueOf(LocalDateTime.now());
    }

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
