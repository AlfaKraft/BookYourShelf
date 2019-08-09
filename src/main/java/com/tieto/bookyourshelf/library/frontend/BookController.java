package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.frontend.models.Book;
import com.tieto.bookyourshelf.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value="book/load", method = RequestMethod.GET)
    public ModelAndView loadBooks() {
        Book model = loadFromDao();
        return new ModelAndView("newBook", "book", model);
    }

    @RequestMapping(value="book/save", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute("book")Book model) {
        bookService.saveBook(model.getBarCode());
        return new ModelAndView("newBook", "book", loadFromDao());
    }

    private Book loadFromDao() {
        Book book = new Book();
        book.setBarCode(bookService.loadBook());
        return book;
    }
}
