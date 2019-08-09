package com.tieto.bookyourshelf.library.dao;

import java.io.IOException;

public interface BookDao {
    String loadBook() throws IOException;

    void saveBook(String person, boolean append) throws IOException;
}
