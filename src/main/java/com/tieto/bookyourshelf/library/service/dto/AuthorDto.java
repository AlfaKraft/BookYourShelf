package com.tieto.bookyourshelf.library.service.dto;

public class AuthorDto {
    public long id;
    public String authorName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
