package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.dao.BookDao;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<BookDto> loadBooks();
    void saveBook(BookDto book);
    BookDto loadById(Long id);
}
