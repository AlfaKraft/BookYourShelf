package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Configuration
public interface BorrowService {

    List<BorrowDto> getAllBorrows();
    BorrowDto getBorrowsById(Long Id);
    List<BorrowDto> getBorrowsByIdUser(Long idUser);
    BorrowDto getBorrowedBookByIdBook(Long idBook);
    BorrowDto getBorrowsByDateTaken(LocalDate dateTaken);
    BorrowDto getBorrowsByDateToBring(Date dateToBring);
    BorrowDto getBorrowsByDateBrought(LocalDate dateBrought);


    List<BorrowDto> loadBorrows();
    void addBorrow(BorrowEnt borrow);
    BorrowDto loadById(Integer id);

}