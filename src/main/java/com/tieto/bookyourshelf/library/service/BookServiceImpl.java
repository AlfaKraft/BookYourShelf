package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.LibraryException;
import com.tieto.bookyourshelf.library.dao.BookDao;
import com.tieto.bookyourshelf.library.dao.entities.BookEnt;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public List<BookDto> loadBooks() {
        try {
            List<BookEnt> ent = bookDao.findAll();
            List<BookDto> ret = ent.stream().map(e -> entToDto(e, null)).collect(Collectors.toList());
            return ret;

        } catch (Exception e){
            throw new LibraryException(e.getMessage(), e);
        }
    }

    @Override
    public void addBook(BookDto book) {
        BookEnt ent;
        try{
            ent = new BookEnt();
            ent = dtoToEnt(book, ent);
            bookDao.save(ent);

        } catch (Exception e){
            throw new LibraryException(e.getMessage(), e);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public BookDto loadById(Integer id) {
        Optional<BookEnt> loaded = bookDao.findById(id);
        if(loaded.isEmpty()) {
            return null;
        }
        return entToDto(loaded.get(), null);
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteBook(Long id) {
        log.info("ID: " + id + " Made it to Service ------------------------------------------------------------------------------------------------------------------------------------------->");

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
        return dto;
    }


}
