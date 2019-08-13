package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.service.BookService;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class AddBookController {
    @Autowired
    BookService bookService;

    private static final Logger log = LoggerFactory.getLogger(AddBookController.class);
    @RequestMapping(value = "book/add", method = RequestMethod.GET)
    public ModelAndView loadAddBooksform(){
        BookDto book;
        book = new BookDto();



        return new ModelAndView("addbooksview", "addbook", book);
    }



    @RequestMapping(value = "book/add", method = RequestMethod.POST)
    public ModelAndView addBook(@ModelAttribute BookDto book) {
        log.info("Entering to addBook");
        try {
            book.setLanguage("EN");
            bookService.addBook(book);
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        try {
            List<BookDto> model = bookService.loadBooks();
            return new ModelAndView("books", "books", model);
        }catch (RuntimeException e){
            throw e;
        }


    }
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }




}
