package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.frontend.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
