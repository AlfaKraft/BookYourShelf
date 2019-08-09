package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.frontend.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class BookController {
    Book book =new Book("Test book", "K. Reree", "true");

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public ModelAndView loadBooks(){
        return new ModelAndView("books", "books" , book);
    }

    @RequestMapping(value="/book", method= RequestMethod.GET)
    public ModelAndView looadBook(){
        return new ModelAndView("book", "book" , book);
    }

    @RequestMapping(value="/lend", method= RequestMethod.GET)
    public ModelAndView lendBook(){
        this.book.setStatus("false");
        return new ModelAndView("lend");
    }

    @RequestMapping(value="/return", method=RequestMethod.GET)
    public ModelAndView returnBook(){
        this.book.setStatus("true");
        return new ModelAndView("returnBook");
    }


}