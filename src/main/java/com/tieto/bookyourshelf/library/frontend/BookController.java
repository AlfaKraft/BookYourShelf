package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.frontend.models.Book;
import com.tieto.bookyourshelf.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    Book book =new Book("Test book", "K. Reree", "true");

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public ModelAndView loadBooks(){
        return new ModelAndView("books", "books" , book);
    }

    @RequestMapping(value="/book", method= RequestMethod.GET)
    public ModelAndView loadBook(){
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
>>>>>>> 2d4ee9dfeb6ff8b56438923e7ca0135ea16d1844
