package com.tieto.bookyourshelf.library.service.dto;

import java.time.LocalDate;
import java.util.Date;

public class BorrowDto {
    private Long id;
    private String name;
    private String title;
    private LocalDate dateTaken;
    private Date dateToBring;
    private LocalDate dateBrought;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(LocalDate dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Date getDateToBring() {
        return dateToBring;
    }

    public void setDateToBring(Date dateToBring) {
        this.dateToBring = dateToBring;
    }

    public LocalDate getDateBrought() {
        return dateBrought;
    }

    public void setDateBrought(LocalDate dateBrought) { this.dateBrought = dateBrought; }
}
