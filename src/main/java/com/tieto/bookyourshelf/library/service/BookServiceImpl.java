package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.LibraryException;
import com.tieto.bookyourshelf.library.dao.BookDao;
import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;
import com.tieto.bookyourshelf.library.frontend.models.Book;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

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
    public void saveBook(BookDto book) {

    }

    @Override
    public BookDto loadById(Long id) {
        return null;
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
        ent.setCover(dto.getCover());
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
