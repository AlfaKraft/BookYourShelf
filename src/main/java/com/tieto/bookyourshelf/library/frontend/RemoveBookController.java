package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.service.BookService;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RemoveBookController {
    private static final Logger log = LoggerFactory.getLogger(RemoveBookController.class);

    @Autowired
    BookService bookService;

    @RequestMapping(value = "books/remove", method = RequestMethod.GET)
    public ModelAndView loadRemoveBooksform(Model model){
        try{
            List<BookDto> list = bookService.loadBooks();
            return new ModelAndView("removeBooksView", "list", list);

        } catch (RuntimeException e){
            throw e;
        }
    }

    @RequestMapping(value = "book/remove", method = RequestMethod.POST)
    public ModelAndView removeBook(@ModelAttribute BookDto bookRemove) throws Exception {

        log.info("Entering to removeBook");
        Long id = bookRemove.getId().longValue();
        bookService.deleteBook(id);
        try {
            List<BookDto> model = bookService.loadBooks();
            return new ModelAndView("books", "books", model);
        }catch (RuntimeException e){
            throw e;
        }

    }
    @RequestMapping(value="book/confirm/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable Integer id) {
        BookDto book;
        System.out.println(id);

        book = bookService.loadById(id);

        return new ModelAndView("confirmRemoval", "bookRemove", book);
    }
}
