package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.LibraryException;
import com.tieto.bookyourshelf.library.dao.AuthorDao;
import com.tieto.bookyourshelf.library.dao.entityes.AuthorEnt;
import com.tieto.bookyourshelf.library.service.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao AuthorDao;

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<AuthorEnt> AuthorEntities=AuthorDao.findAll();
        List<AuthorDto> Authors = AuthorEntities.stream().map(e -> entToDto(e, null)).collect(Collectors.toList());
        return Authors;
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        Optional<AuthorEnt> Author=AuthorDao.findById(id);
        return entToDto(Author.get(), null);
    }

    @Override
    public void saveAuthor(AuthorDto Author) {
        AuthorEnt ent;
        try{
            ent = new AuthorEnt();
            ent = dtoToEnt(Author, ent);
            AuthorDao.save(ent);

        } catch (Exception e){
            throw new LibraryException(e.getMessage(), e);
        }

    }

    private AuthorEnt dtoToEnt(AuthorDto dto, AuthorEnt ent) {
        if (dto == null) {
            return null;
        }
        if (ent == null) {
            throw new IllegalArgumentException("Argument ent can not be null");
        }
        //ent.setId(dto.getId());
        ent.setAuthorName(dto.getAuthorName());
        return ent;

    }


    private AuthorDto entToDto(AuthorEnt ent, AuthorDto dto) {
        if (ent == null) {
            return null;
        }
        if (dto == null) {
            dto = new AuthorDto();
        }

        dto.setId(ent.getId());
        dto.setAuthorName(ent.getAuthorName());

        return dto;
    }


}
