package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.LibraryException;
import com.tieto.bookyourshelf.library.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    public String loadBook() {
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
    }
}
