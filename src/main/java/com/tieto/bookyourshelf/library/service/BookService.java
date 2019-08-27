package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.frontend.models.Book;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

     List<BookDto> getAllBooks();

     BookDto getBookById(Long Id);

     BookDto getBookByBarcode(Long barCode);

     void updateBookStatus(Long id, boolean status);

     void deleteBook(Long id);

     void returnDate(Long id, LocalDate date);

     /*
    //String loadBook();

    //void saveBook(String book);*/

    List<BookDto> loadBooks();
    void addBook(BookDto book);
    BookDto loadById(Integer id);

}
