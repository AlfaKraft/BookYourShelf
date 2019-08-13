package com.tieto.bookyourshelf.library.dao.impl;
import com.tieto.bookyourshelf.library.dao.BookDao;
import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    //list is working as a database
    List<BookEnt> books;

    public BookDaoImpl(){
        books = new ArrayList<BookEnt>();
        BookEnt book1 = new BookEnt(0,"Effective Java", "9780134685991", "Java", "EN", 2018, true );
        BookEnt book2 = new BookEnt(1,"Learn Java in One Day and Learn It Well (Learn Coding Fast) (Volume 4)", "9781911223139", "Java", "EN", 2016, true );
        BookEnt book3 = new BookEnt(2,"Java: The Complete Reference, Eleventh Edition", "9781260440232", "Java", "EN", 2018 , true );
        BookEnt book4 = new BookEnt(3,"Python: Learn Python in One Day and Learn It Well. Python for Beginners with Hands-on Project. (Learn Coding Fast with Hands-On Project Book 1)", "9781506094380", "Java", "EN", 2016 , true);
        BookEnt book5 = new BookEnt(4,"Java Programming for Beginners: Learn the fundamentals of programming with Java", "9781788296298", "Java", "EN", 2017, true );

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
    }
    @Override
    public void deleteBook(BookEnt book) {
        books.remove(book.getId());
    }

    //retrieve list of students from the database
    @Override
    public List<BookEnt> getAllBooks() {
        return books;
    }

    @Override
    public BookEnt getBook(int id) {
        return books.get(id);
    }

    @Override
    public BookEnt getBookByBarcode(String barCode) {
        return books.stream().filter((s) -> s.getBarCode().equals(barCode)).findFirst().orElseGet( null);
    }

    @Override
    public void updateBook( int id) {
        books.get(id).setStatus((false));
        //books.get(book.getId()).setStatus(book.getStatus());
    }
}