package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.frontend.models.Book;
import com.tieto.bookyourshelf.library.service.BookService;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookListController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "book/load", method = RequestMethod.GET)
    public ModelAndView loadBooks(){
        try{
            List<BookDto> model = new ArrayList<BookDto>(); // bookService.loadBooks();
            return new ModelAndView("books", "books", model);

        } catch (RuntimeException e){
            throw e;
        }
    }
}
