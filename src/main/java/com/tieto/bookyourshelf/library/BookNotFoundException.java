package com.tieto.bookyourshelf.library;

public final class BookNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BookNotFoundException(final String message) {
        super(message);
    }

    public BookNotFoundException(final Throwable cause) {
        super(cause);
    }

}
