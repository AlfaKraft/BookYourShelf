package com.tieto.bookyourshelf.library.dao.entityes;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "books", schema = "bys_db")
public class BookEnt {

    private long id;
    private String title;
    private Long isbnCode;
    private String genre;
    private String language;
    private Integer year;
    private String cover;
    private boolean status;
    private Set<AuthorEnt> authors;

    public BookEnt() {
    }

    public BookEnt(String title, Long isbnCode, String genre, String language, Integer year, String cover, boolean status, Set<AuthorEnt> authors) {
        this.title = title;
        this.isbnCode = isbnCode;
        this.genre = genre;
        this.language = language;
        this.year = year;
        this.cover = cover;
        this.status = status;
        this.authors = authors;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
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


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "AUTHOR_BOOK",
            joinColumns = @JoinColumn(name = "idBook"),
            inverseJoinColumns = @JoinColumn(name = "idAuthor")
    )


    public Set<AuthorEnt> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorEnt> authors) {
        this.authors = authors;
    }

}

