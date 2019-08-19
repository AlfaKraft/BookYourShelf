package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.service.dto.BorrowDto;

import java.util.Date;
import java.util.List;

public interface BorrowService {

    List<BorrowDto> getAllBorrows();
    BorrowDto getBorrowsById(Long Id);
    BorrowDto getBorrowsByIdUser(Long idUser);
    BorrowDto getBorrowsByIdBook(Long idBook);
    BorrowDto getBorrowsByDateTaken(Date dateTaken);
    BorrowDto getBorrowsByDateToBring(Date dateToBring);
    BorrowDto getBorrowsByDateBrought(Date dateBrought);




    List<BorrowDto> loadBorrows();
    void addBorrow(BorrowDto borrow);
    BorrowDto loadById(Integer id);

}
