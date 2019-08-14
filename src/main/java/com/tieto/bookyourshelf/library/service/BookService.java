package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;
import com.tieto.bookyourshelf.library.service.dto.BookDto;

import java.util.List;

public interface BookService {

     List<BookDto> getAllBooks();

     BookDto getBookById(Long Id);

     BookDto getBookByBarcode(Long barCode);

     void updateBookStatus(Long id, boolean status);
/*
    //String loadBook();

    //void saveBook(String book);*/

}
