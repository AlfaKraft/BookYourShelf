package com.tieto.bookyourshelf.library.dao.entityes;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name =  "borrows" , schema = "bys_db")
public class BorrowEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "idUser")
    private Long idUser;
    @Column(name = "idBook")
    private Long idBook;
    @Column(name = "dateTaken")
    private LocalDate dateTaken;
    @Column(name = "dateToBring")
    private Date dateToBring;
    @Column(name = "dateBrought")
    private LocalDate dateBrought;





    public BorrowEnt() {
    }

    public BorrowEnt(Long idUser, Long idBook, LocalDate dateTaken, Date dateToBring, LocalDate dateBrought) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.dateTaken = dateTaken;
        this.dateToBring = dateToBring;
        this.dateBrought = dateBrought;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() { return idUser; }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public LocalDate getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(LocalDate dateTaken) { this.dateTaken = dateTaken; }

    public Date getDateToBring() {
        return dateToBring;
    }

    public void setDateToBring(Date dateToBring) {
        this.dateToBring = dateToBring;
    }

    public LocalDate getDateBrought() {
        return dateBrought;
    }

    public void setDateBrought(LocalDate dateBrought) {
        this.dateBrought = dateBrought;
    }


}
