package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.BookAlreadyExistException;
import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.service.BookService;
import com.tieto.bookyourshelf.library.service.BorrowService;
import com.tieto.bookyourshelf.library.service.UserService;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.transaction.Transactional;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Calendar;
import java.util.List;
import java.util.HashMap;
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

    @Autowired
    ServletContext context;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView getAllBooks() {
        List<BookDto> books=bookService.getAllBooks();
        return new ModelAndView("books", "books", books);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    @Transactional
    public ModelAndView getBook(@PathVariable Long id) {
        BookDto book = bookService.getBookById(id);
        BorrowDto borrowDto = borrowService.getBorrowedBookByIdBook(id);
        if(borrowDto != null){
            book.setBorrower(borrowDto.getName());
        }
        return new ModelAndView("book", "book", book);
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView getBookByBarcode(@RequestParam(name = "barcode", required = true) Long barCode) throws MissingServletRequestParameterException {
        try {
            BookDto book = bookService.getBookByBarcode(barCode);
            Long id = book.getId();
            BorrowDto borrowDto = borrowService.getBorrowedBookByIdBook(id);
            if(borrowDto != null){
                book.setBorrower(borrowDto.getName());
            }
            return new ModelAndView("book", "book", book);
        } catch (MissingServletRequestParameterException e) {
            throw new MissingServletRequestParameterException("barCode","Long");
        }
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMyException(Exception  e, RedirectAttributes redirectAttrs) {

        redirectAttrs.addFlashAttribute("errorMessage", "No book with this barcode could not be found. Try to scan again!");
        String redirectUrl = "/app/scanBook?form";
        return "redirect:" + redirectUrl;
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
    public ModelAndView lendBook(@ModelAttribute("errorMessage") final String errorMessage, Model model) {

        if(errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
        }
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
    public ModelAndView addBook(@ModelAttribute ("book") @Valid BookDto book, BindingResult br) throws IOException {
        log.info("Entering to addBook");

        if (!book.getCoverImage().isEmpty()) {
            byte[] bytes = book.getCoverImage().getBytes();
            Path path = Paths.get(context.getRealPath("/img/")+ book.getCoverImage().getOriginalFilename());
            Files.write(path, bytes);
        }

        if (br.hasErrors()) {
            return new ModelAndView("addBook");
        } else {
            try {
                book.setStatus(true);
                book.setCover(book.getCoverImage().getOriginalFilename());
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

    @RequestMapping(value = "book/new_v2", method = RequestMethod.POST)
    public String addBookv2(@ModelAttribute ("book") BookDto book, BindingResult br) {
        log.info("Entering to addBook " + book.getTitle());
        return "redirect:/";

}


    @PostMapping("book/new_v3")
    public String multiUploadFileModel(@RequestParam("file") MultipartFile file) {
        log.info("importing file >>>"+ file.getOriginalFilename()+ " "+file.getSize());
        return "redirect:/";
    }


}




