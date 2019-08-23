package com.tieto.bookyourshelf.library.frontend.models;

import com.tieto.bookyourshelf.library.dao.entityes.AuthorEnt;

import java.util.Set;

public class Book {
    private int id;
    private String title;
    private String barCode;
    private String genre;
    private String language;
    private int year;
    private Boolean status;
    //private Set<AuthorEnt> authors;

    private String author1;
    private String author2;




    public Book() {
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

    /*public Set<AuthorEnt> getAuthors() {
        return authors;
    }*/

    public String getAuthor1() {
        return author1;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    /*public void setAuthors(Set<AuthorEnt> authors) {
        this.authors = authors;
    }*/
}
