package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.LibraryException;
import com.tieto.bookyourshelf.library.dao.BookDao;
import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;
import com.tieto.bookyourshelf.library.frontend.models.Book;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public List<BookDto> getAllBooks() {
        List<BookDto> ret;
        try {
            List<BookEnt> ent = bookDao.findAll();
             ret = ent.stream().map(e -> entToDto(e, null)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
        return ret;
    }


    public BookDto getBookById(Long id) {
        Optional<BookEnt> book=bookDao.findById(id);
        if (book.isEmpty()) {
            return null;
        }
        return entToDto(book.get(), null);
    }

    public BookDto getBookByBarcode(Long barCode) {
        BookEnt book= bookDao.findBookEntByIsbnCode(barCode);
        return entToDto(book, null);
    }

    public void deleteBook(Long id){
        bookDao.deleteById(id);
    }

    private BookEnt dtoToEnt(BookDto dto, BookEnt ent) {
        if (dto == null) {
            return null;
        }
        if (ent == null) {
            throw new IllegalArgumentException("Argument ent can not be null");
        }
        ent.setId(dto.getId());
        ent.setIsbnCode(dto.getIsbnCode());
        ent.setGenre(dto.getGenre());
        ent.setLanguage(dto.getLanguage());
        ent.setTitle(dto.getTitle());
        ent.setYear(dto.getYear());
        ent.setStatus(dto.getStatus());
        return ent;

    }
    private BookDto entToDto(BookEnt ent, BookDto dto) {
        if (ent == null) {
            return null;
        }
        if (dto == null) {
            dto = new BookDto();
        }

        dto.setId(ent.getId());
        dto.setIsbnCode(ent.getIsbnCode());
        dto.setGenre(ent.getGenre());
        dto.setLanguage(ent.getLanguage());
        dto.setTitle(ent.getTitle());
        dto.setCover(ent.getCover());
        dto.setYear(ent.getYear());
        dto.setStatus(ent.getStatus());
        return dto;
    }



    public void updateBookStatus(Long id, boolean status) {
        try {
            BookEnt book=bookDao.findById(id).get();
            book.setStatus(status);
            bookDao.save(book);
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
    }



}

    /*public String loadBook() {
        String ret;
        try {
            ret = bookDao.loadBook();
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
        return ret;
    }

    public void saveBook(String book) {
        try {
            bookDao.saveBook(book, true);
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
    }*/

