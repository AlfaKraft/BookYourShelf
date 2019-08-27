package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.dao.entityes.AuthorEnt;
import com.tieto.bookyourshelf.library.service.BookService;
import com.tieto.bookyourshelf.library.service.dto.AuthorDto;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);



    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView getAllBooks() {
        List<BookDto> books=bookService.getAllBooks();
        return new ModelAndView("books", "books", books);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    @Transactional
    public ModelAndView getBook(@PathVariable Long id) {
        BookDto book = bookService.getBookById(id);
        return new ModelAndView("book", "book", book);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView getBookByBarcode( @RequestParam("barcode") Long barCode) {
        BookDto book = bookService.getBookByBarcode(barCode);
        return new ModelAndView("book", "book", book);
    }


    @RequestMapping(value = "/lendBook/{id}", method = RequestMethod.GET)
    public String lendBook(@PathVariable Long id) {
        bookService.updateBookStatus(id, false);
        return "redirect:/app/books";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/app/books";
    }

    @RequestMapping(value = "/returnBook/{id}", method = RequestMethod.GET)
    public String returnBook(@PathVariable Long id) {
        bookService.updateBookStatus(id, true);
        return "redirect:/app/books";
    }


    @RequestMapping(value = "/scanBook", method = RequestMethod.GET)
    public ModelAndView lendBook() {
        return new ModelAndView("scanBook");
    }


    @ModelAttribute
    public void addAttributes(Model model){
        try{
            List<BookDto> list = bookService.loadBooks();
            model.addAttribute("list", list);
            List<String> languages = new ArrayList<>();
            languages.add("EN");
            languages.add("EST");
            languages.add("ESP");
            BookDto book;
            book = new BookDto();
            model.addAttribute("addbook", book);
            model.addAttribute("languageList", languages);

        } catch (RuntimeException e){
            throw e;
        }
    }


    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ModelAndView addBook(@ModelAttribute BookDto book) {
        log.info("Entering to addBook");
        try {
            book.setStatus(true);
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

    //@@Scheduled(cron="0 0 0 ? * MON-FRI *")
    /*@Scheduled(fixedRate=5000)
    public void ScheduledFixedRate(){
        System.out.println("I will execute after evey 5 seconds");
    }*/
}




