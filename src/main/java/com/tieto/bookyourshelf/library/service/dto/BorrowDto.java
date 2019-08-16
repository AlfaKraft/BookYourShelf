package com.tieto.bookyourshelf.library.service.dto;

import java.util.Date;

public class BorrowDto {
    private Long id;
    private Long idUser;
    private Long idBook;
    private Date dateTaken;
    private Date dateToBring;
    private Date dateBrought;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Date getDateToBring() {
        return dateToBring;
    }

    public void setDateToBring(Date dateToBring) {
        this.dateToBring = dateToBring;
    }

    public Date getDateBrought() {
        return dateBrought;
    }

    public void setDateBrought(Date dateBrought) {
        this.dateBrought = dateBrought;
    }
}
