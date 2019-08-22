package com.tieto.bookyourshelf.library.dao;

import com.tieto.bookyourshelf.library.dao.entityes.AuthorEnt;
import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorDao extends JpaRepository<AuthorEnt, Long>{

    List<AuthorEnt> findAll();
    AuthorEnt save(AuthorEnt authorEnt);
    Optional<AuthorEnt> findById(Long aLong);
    List<AuthorEnt> findAllById(Iterable<Long> iterable);

}


    /*ist<BookEnt> findAll();
    BookEnt save(BookEnt book);
    Optional<BookEnt> findById(Integer id);
    BookEnt findBookEntByIsbnCode(Long isbnCode);*/
