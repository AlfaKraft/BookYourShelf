package com.tieto.bookyourshelf.library.frontend.models;

public class Book {

    private String name;
    private String author;
    private String status;

    public Book(String name, String author, String status) {
        this.name=name;
        this.author=author;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
