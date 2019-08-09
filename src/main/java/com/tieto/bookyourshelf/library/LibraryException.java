package com.tieto.bookyourshelf.library;

public class LibraryException extends RuntimeException {

   public LibraryException(String message, Throwable e) {
      super(message, e);
   }

}
