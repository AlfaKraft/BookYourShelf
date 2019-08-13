package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.LibraryException;
import com.tieto.bookyourshelf.library.dao.BookDao;
import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;
import com.tieto.bookyourshelf.library.frontend.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public List<BookEnt> getAllBooks() {
        List<BookEnt> ret;
        try {
            ret = bookDao.getAllBooks();
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
        return ret;
    }

    public BookEnt getBook(int id) {
        BookEnt book;
        try {
            book = bookDao.getBook(id);
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
        return book;
    }

    public BookEnt getBookByBarcode(String barCode) {
        BookEnt book;
        try {
            book = bookDao.getBookByBarcode(barCode);
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
        return book;
    }

    public void updateBook(int id) {
        try {
           // bookDao.getBook(id);
           // book.setStatus(false);
            bookDao.updateBook( id);
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
      //  return book;
    }
}

    /*public String loadBook() {
        String ret;
        try {
            ret = bookDao.loadBook();
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
        return ret;
    }

    public void saveBook(String book) {
        try {
            bookDao.saveBook(book, true);
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
    }*/

