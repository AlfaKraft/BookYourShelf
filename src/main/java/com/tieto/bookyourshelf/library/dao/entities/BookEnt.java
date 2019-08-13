package com.tieto.bookyourshelf.library.dao.entities;

import javax.persistence.*;

@Entity
@Table(name = "books", schema = "bys_db")
public class BookEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public BookEnt(String title, Long isbnCode, String genre, String language, Integer year, String cover) {
        this.title = title;
        this.isbnCode = isbnCode;
        this.genre = genre;
        this.language = language;
        this.year = year;
        this.cover = cover;
    }

    public BookEnt() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(Long isbnCode) {
        this.isbnCode = isbnCode;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
