package com.tieto.bookyourshelf.library;

public final class BookAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public BookAlreadyExistException() {
        super();
    }

    public BookAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BookAlreadyExistException(final String message) {
        super(message);
    }

    public BookAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}
