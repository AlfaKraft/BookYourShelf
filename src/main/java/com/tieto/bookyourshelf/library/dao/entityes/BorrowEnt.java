package com.tieto.bookyourshelf.library.dao.entityes;

import com.tieto.bookyourshelf.library.service.BorrowService;

import javax.persistence.*;
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
    private Date dateTaken;
    @Column(name = "dateToBring")
    private Date dateToBring;
    @Column(name = "dateBrought")
    private Date dateBrought;

    public BorrowEnt() {
    }

    public BorrowEnt(Long idUser, Long idBook, Date dateTaken, Date dateToBring, Date dateBrought) {
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
