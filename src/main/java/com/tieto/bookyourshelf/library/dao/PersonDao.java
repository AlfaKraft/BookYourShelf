package com.tieto.bookyourshelf.library.dao;

import java.io.IOException;

public interface PersonDao {
   String loadPerson() throws IOException;

   void savePerson(String person, boolean append) throws IOException;
}
