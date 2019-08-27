package com.tieto.bookyourshelf.library.service.dto;

import com.tieto.bookyourshelf.library.dao.entityes.AuthorEnt;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class BookDto {
    private Long id;
    @NotEmpty
    private String title;
    private Long isbnCode;
    @NotEmpty
    private String genre;
    @NotEmpty
    private String language;
    @NotNull
    private Integer year;
    private String cover;
    private Set<AuthorEnt> authors;
    private String author1;
    private String author2;

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

    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<AuthorEnt> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorEnt> authors) {
        this.authors = authors;
    }
}
