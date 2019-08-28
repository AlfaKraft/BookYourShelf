package com.tieto.bookyourshelf.library.dao;
import com.tieto.bookyourshelf.library.dao.entityes.AuthorEnt;
import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Optional;

@Repository
public interface BookDao extends JpaRepository<BookEnt, Long> {

    List<BookEnt> findAll();
    BookEnt save(BookEnt book);
    Optional<BookEnt> findById(Integer id);
    BookEnt findBookEntByIsbnCode(Long isbnCode);
    BookEnt findBookEntById(Long id);
    BookEnt findByTitle(String title);

}



