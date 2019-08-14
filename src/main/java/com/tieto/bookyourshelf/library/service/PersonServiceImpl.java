package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.LibraryException;
import com.tieto.bookyourshelf.library.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

   //@Autowired
   private PersonDao personDao;

   public String loadPerson() {
      String ret;
      try {
         ret = personDao.loadPerson();
      } catch (Exception e) {
         throw new LibraryException(e.getMessage(), e);
      }
      return ret;
   }

   public void savePerson(String person) {
      try {
         personDao.savePerson(person, true);
      } catch (Exception e) {
         throw new LibraryException(e.getMessage(), e);
      }
   }
}
