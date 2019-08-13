package com.tieto.bookyourshelf.library.dao;
import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;

import java.util.List;
import java.io.IOException;


public interface BookDao {


    public List<BookEnt> getAllBooks();

    public BookEnt getBook(int id);

    public BookEnt getBookByBarcode(String barCode);

    public void updateBook( int id);

    public void deleteBook(BookEnt book);
}


