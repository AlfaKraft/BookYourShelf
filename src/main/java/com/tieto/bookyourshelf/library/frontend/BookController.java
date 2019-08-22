package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.frontend.models.User;
import com.tieto.bookyourshelf.library.service.BookService;
import com.tieto.bookyourshelf.library.service.BorrowService;
import com.tieto.bookyourshelf.library.service.UserService;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView getAllBooks() {
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


    @RequestMapping(value = "/lendBook/{id}", method = RequestMethod.GET)
    public String lendBook(@PathVariable Long id) {
        bookService.updateBookStatus(id, false);
        BorrowEnt borrowEnt = new BorrowEnt();
        LocalDate borrowedDate = LocalDate.now();
        borrowEnt.setDateTaken(borrowedDate);
        LocalDate dateToBring = borrowedDate.plusDays(14);
        Date dateBring = java.sql.Date.valueOf(dateToBring);
        borrowEnt.setDateToBring(dateBring);
        borrowEnt.setIdBook(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        borrowEnt.setIdUser(userService.getUserByEmail(email).getId());
        borrowService.addBorrow(borrowEnt);
        return "redirect:/app/books";
    }

    @RequestMapping(value = "/returnBook/{id}", method = RequestMethod.GET)
    public String returnBook(@PathVariable Long id) {
        bookService.updateBookStatus(id, true);
        LocalDate returnDate = LocalDate.now();
        bookService.returnDate(id, returnDate);

        return "redirect:/app/books";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
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


    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal){
        return principal.getName();
    }


}




