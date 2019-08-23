package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.LibraryException;
import com.tieto.bookyourshelf.library.dao.AuthorDao;
import com.tieto.bookyourshelf.library.dao.BookDao;
import com.tieto.bookyourshelf.library.dao.BorrowDao;
import com.tieto.bookyourshelf.library.dao.entityes.AuthorEnt;
import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;
import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.frontend.models.Book;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao autDao;
    @Autowired
    private BorrowDao borrowDao;

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
        Optional<BookEnt> book = bookDao.findById(id);
        if (book.isEmpty()) {
            return null;
        }
        return entToDto(book.get(), null);
    }

    public BookDto getBookByBarcode(Long barCode) {
        BookEnt book = bookDao.findBookEntByIsbnCode(barCode);
        return entToDto(book, null);
    }

    public void deleteBook(Long id) {
        bookDao.deleteById(id);
    }


    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);


    @Transactional
    @Override
    public List<BookDto> loadBooks() {
        try {
            List<BookEnt> ent = bookDao.findAll();
            List<BookDto> ret = ent.stream().map(e -> entToDto(e, null)).collect(Collectors.toList());
            return ret;

        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
    }

    @Override
    public void addBook(BookDto book) {
        BookEnt ent;
        try {
            ent = new BookEnt();
            ent = dtoToEnt(book, ent);
            bookDao.save(ent);
            //ent.getAuthors().stream().forEach(a -> autDao.save(a));

        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }

    }

    @Override
    @Transactional
    public BookDto loadById(Integer id) {
        Optional<BookEnt> loaded = bookDao.findById(id);
        if (loaded.isEmpty()) {
            return null;
        }
        return entToDto(loaded.get(), null);
    }


    private BookEnt dtoToEnt(BookDto dto, BookEnt ent) {
        if (dto == null) {
            return null;
        }
        if (ent == null) {
            throw new IllegalArgumentException("Argument ent can not be null");
        }
        //ent.setId(dto.getId());
        ent.setIsbnCode(dto.getIsbnCode());
        ent.setGenre(dto.getGenre());
        ent.setLanguage(dto.getLanguage());
        ent.setTitle(dto.getTitle());
        ent.setYear(dto.getYear());
        ent.setStatus(dto.getStatus());
        //ent.setAuthors(dto.getAuthors());
        Set<AuthorEnt> authors = new HashSet<AuthorEnt>();
        AuthorEnt auth = new AuthorEnt();
        auth.setAuthorName(dto.getAuthor1());
        authors.add(auth);
        auth = new AuthorEnt();
        auth.setAuthorName(dto.getAuthor2());
        authors.add(auth);
        ent.setAuthors(authors);
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
        //dto.setAuthors(ent.getAuthors());

        return dto;
    }

    public void updateBookStatus(Long id, boolean status) {
        try {
            BookEnt book = bookDao.findById(id).get();
            book.setStatus(status);
            bookDao.save(book);
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
    }

    public void returnDate(Long id, LocalDate date) {
        try {
            BorrowEnt borrowEnt = borrowDao.findBorrowEntByIdBookAndDateBrought(id, null);
            borrowEnt.setDateBrought(date);
            borrowDao.save(borrowEnt);
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


