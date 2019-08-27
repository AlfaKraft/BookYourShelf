package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.BookAlreadyExistException;
import com.tieto.bookyourshelf.library.BookNotFoundException;
import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.frontend.models.User;
import com.tieto.bookyourshelf.library.service.BookService;
import com.tieto.bookyourshelf.library.service.AuthorService;
import com.tieto.bookyourshelf.library.service.BorrowService;
import com.tieto.bookyourshelf.library.service.UserService;
import com.tieto.bookyourshelf.library.service.dto.AuthorDto;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.transaction.Transactional;

import javax.validation.Valid;
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
    @Transactional
    public ModelAndView getBook(@PathVariable Long id) {
        BookDto book = bookService.getBookById(id);
        BorrowDto borrowDto = borrowService.getBorrowsByIdBook(id);
        if(borrowDto != null){
            book.setBorrower(borrowDto.getName());
        }
        return new ModelAndView("book", "book", book);
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView getBookByBarcode(@RequestParam("barcode") Long barCode) {
        try {
        BookDto book = bookService.getBookByBarcode(barCode);
        return new ModelAndView("book", "book", book);
        } catch (Exception e) {
           // throw new MissingServletRequestParameterException(barCode, "Long");
            return new ModelAndView("scanBook");
        }
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public void handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        System.out.println(name + " parameter is missing");
        // Actual exception handling
    }


    @RequestMapping(value = "/lendBook/{id}", method = RequestMethod.GET)
    public String lendBook(@PathVariable Long id) {
        if(bookService.getBookById(id).getStatus() == true) {
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
        }
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


    @RequestMapping(value = "book/new", method = RequestMethod.POST)
    public ModelAndView addBook(@ModelAttribute ("book") @Valid BookDto book, BindingResult br) {
        log.info("Entering to addBook");
        if (br.hasErrors()) {
            return new ModelAndView("addBook");
        } else {
            try {
                book.setStatus(true);
                bookService.addBook(book);
                return new ModelAndView("books", "books", bookService.getAllBooks());
            } catch (BookAlreadyExistException e) {
                br.rejectValue("title", "title.alreadyexists", "A book with that title already exists");
                return new ModelAndView("addBook");
            }
        }

    }

    @RequestMapping(value="book/add", method = RequestMethod.GET)
    public ModelAndView insertBook(){
        BookDto book=new BookDto();
        return new ModelAndView("addBook","book",book);
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal){
        return principal.getName();

    }

    //@@Scheduled(cron="0 0 0 ? * MON-FRI *")
    /*@Scheduled(fixedRate=5000)
    public void ScheduledFixedRate(){
        System.out.println("I will execute after evey 5 seconds");
    }*/
}




