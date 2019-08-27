package com.tieto.bookyourshelf.library.service;


import com.tieto.bookyourshelf.library.BookAlreadyExistException;
import com.tieto.bookyourshelf.library.BookNotFoundException;
import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;
import com.tieto.bookyourshelf.library.service.dto.BookDto;

import java.util.List;

public interface BookService {

     List<BookDto> getAllBooks();

     BookDto getBookById(Long Id);

     BookDto getBookByBarcode(Long barCode)throws BookNotFoundException;

     void updateBookStatus(Long id, boolean status);

     void deleteBook(Long id);
/*
    //String loadBook();

    //void saveBook(String book);*/

    List<BookDto> loadBooks();
    BookEnt addBook(BookDto book) throws BookAlreadyExistException;
    BookDto loadById(Integer id);



}
