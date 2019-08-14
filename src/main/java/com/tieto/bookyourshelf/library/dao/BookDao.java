package com.tieto.bookyourshelf.library.dao;
import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.io.IOException;


@Repository
public interface BookDao extends JpaRepository<BookEnt, Long> {

    List<BookEnt> findAll();
    BookEnt save(BookEnt book);

    BookEnt findBookEntByIsbnCode(Long isbnCode);

}


