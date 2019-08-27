package com.tieto.bookyourshelf.library.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BorrowDto {
    private Long id;
    private String name;
    private String title;
    private String dateTaken;
    private String dateToBring;
    private String dateBrought;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getDateToBring() {
        return dateToBring;
    }

    public void setDateToBring(String dateToBring) {
        this.dateToBring = dateToBring;
    }

    public String getDateBrought() {
        return dateBrought;
    }

    public void setDateBrought(String dateBrought) {
        this.dateBrought = dateBrought;
    }
}