package com.tieto.bookyourshelf.library.frontend.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "ISBNcode")
    private Long isbnCode;
    @Column(name = "genre")
    private String genre;
    @Column(name = "language")
    private String language;
    @Column(name = "year")
    private Integer year;
    @Column(name = "picture")
    private String cover;

    public Book() {
    }

    public Book(Integer id, String title, Long isbnCode, String genre, String language, Integer year, String cover) {
        this.id = id;
        this.title = title;
        this.isbnCode = isbnCode;
        this.genre = genre;
        this.language = language;
        this.year = year;
        this.cover = cover;
    }


}
