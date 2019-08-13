package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.frontend.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/book")
public class BookListController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/all")
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
}
