package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;

import java.util.List;

public interface BookService {

     List<BookEnt> getAllBooks();

     BookEnt getBook(int Id);

     BookEnt getBookByBarcode(String barCode);

     void updateBook(int id);

    //String loadBook();

    //void saveBook(String book);

}
