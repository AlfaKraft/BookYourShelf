package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.service.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAllAuthors();
    AuthorDto getAuthorById(Long id);
    void saveAuthor(AuthorDto user);

}
