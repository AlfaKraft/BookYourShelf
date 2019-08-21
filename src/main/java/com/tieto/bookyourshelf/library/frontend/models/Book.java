package com.tieto.bookyourshelf.library.frontend.models;

public class Book {
    private int id;
    private String title;
    private String barCode;
    private String genre;
    private String language;
    private int year;
    private Boolean status;

    public Book(int id, String title, String barCode, String genre, String language, int year, boolean status){
        this.id = id;
        this.title = title;
        this.barCode = barCode;
        this.genre = genre;
        this.language = language;
        this.year = year;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int rollNo) {
        this.id = id;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) { this.status = status; }

}
