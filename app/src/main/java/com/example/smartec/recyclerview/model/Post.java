package com.example.smartec.recyclerview.model;

/**
 * Created by Smartec on 3/13/2018.
 */

public class Post {
    private String header;
    private String title;
    public Post(String header, String title) {
        this.header = header;
        this.title = title;
    }
    public Post() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
