package com.tieto.bookyourshelf.library.service.dto;

public class BookDto {
    private Long id;
    private String title;
    private Long isbnCode;
    private String genre;
    private String language;
    private Integer year;
    private String cover;

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


}
