package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.service.BookService;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView getAllBooks() {
        //List<BookEnt> books = bookService.getAllBooks();
        List<BookDto> books=bookService.getAllBooks();
        return new ModelAndView("books", "books", books);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ModelAndView getBook(@PathVariable Long id) {
        BookDto book = bookService.getBookById(id);
        return new ModelAndView("book", "book", book);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView getBookByBarcode( @RequestParam("barcode") Long barCode) {
        BookDto book = bookService.getBookByBarcode(barCode);
        return new ModelAndView("book", "book", book);
    }

/*
    @RequestMapping(value = "/updateBook/{id}", method = RequestMethod.GET)
    public String updateBook(@PathVariable int id) {
        bookService.updateBook(id);
        return "redirect:/app/books";
    }*/


    @RequestMapping(value = "/lend", method = RequestMethod.GET)
    public ModelAndView lendBook() {
        return new ModelAndView("lend");
    }
}




