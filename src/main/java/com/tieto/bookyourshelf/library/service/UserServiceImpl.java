package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.LibraryException;
import com.tieto.bookyourshelf.library.dao.UserDao;
import com.tieto.bookyourshelf.library.dao.entityes.UserEnt;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional (readOnly = true)
    @Override
    public List<UserDto> loadUsers() {
        try {
            List<UserEnt> ent = userDao.findAll();
            List<UserDto> ret = ent.stream().map(e -> entToDto(e, null)).collect(Collectors.toList());
            return ret;

        } catch (Exception e){
            throw new LibraryException(e.getMessage(), e);
        }
    }

    @Override
    public void saveUser(UserDto user) {
        UserEnt ent;
        try {
            if (user.getId() == null) {
                ent = new UserEnt();
            } else {
                Optional<UserEnt> loaded = userDao.findById(user.getId());
                if (loaded.isEmpty()) {
                    throw new Exception("Person(ID=" + user.getId() + ") not found");
                }
                ent = loaded.get();
            }
            ent = dtoToEnt(user, ent);
            userDao.save(ent);
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
    }

    @Override
    public UserDto loadById(Long id) {

        Optional<UserEnt> loaded = userDao.findById(id);
        if (loaded.isEmpty()) {
            return null;
        }
        return entToDto(loaded.get(), null);
    }


    private UserEnt dtoToEnt(UserDto dto, UserEnt ent) {
        if (dto == null) {
            return null;
        }
        if (ent == null) {
            throw new IllegalArgumentException("Argument ent can not be null");
        }
        ent.setId(dto.getId());
        ent.setFirstName(dto.getFirstName());
        ent.setLastName(dto.getLastName());
        ent.setPicture(dto.getPicture());
        ent.setEmail(dto.getEmail());
        ent.setPassword(dto.getPassword());
        ent.setRole(dto.getRole());

        return ent;

    }
    private UserDto entToDto(UserEnt ent, UserDto dto) {
        if (ent == null) {
            return null;
        }
        if (dto == null) {
            dto = new UserDto();
        }
        dto.setId(ent.getId());
        dto.setFirstName(ent.getFirstName());
        dto.setLastName(ent.getLastName());
        dto.setPicture(ent.getPicture());
        dto.setEmail(ent.getEmail());
        dto.setPassword(ent.getPassword());
        dto.setRole(ent.getRole());
        return dto;
    }
}
