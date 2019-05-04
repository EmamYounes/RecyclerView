package com.example.smartec.recyclerview.model;

/**
 * Created by Smartec on 3/13/2018.
 */

public class Book {
    private String title,category,description;
    private int image;

    public Book() {
    }

    public Book(String title, String category, String description, int image) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.image = image;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
