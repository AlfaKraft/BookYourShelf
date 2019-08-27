package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BorrowService {

    List<BorrowDto> getAllBorrows();
    BorrowDto getBorrowsById(Long Id);
    List<BorrowDto> getBorrowsByIdUser(Long idUser);
    BorrowDto getBorrowedBookBIdBook(Long idBook);
    BorrowDto getBorrowsByDateTaken(LocalDate dateTaken);
    BorrowDto getBorrowsByDateToBring(Date dateToBring);
    BorrowDto getBorrowsByDateBrought(LocalDate dateBrought);


    List<BorrowDto> loadBorrows();
    void addBorrow(BorrowEnt borrow);
    BorrowDto loadById(Integer id);

}
