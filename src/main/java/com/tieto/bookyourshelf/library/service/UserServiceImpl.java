package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.dao.UserDao;
import com.tieto.bookyourshelf.library.dao.entityes.UserEnt;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEnt> userEntities=userDao.findAll();
        List<UserDto> users = userEntities.stream().map(e -> entToDto(e, null)).collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<UserEnt> user=userDao.findById(id);
        return entToDto(user.get(), null);
    }

    @Override
    public void saveUser(UserDto user) {

        UserEnt userEntity;
        if(user.getId()==null){
            userEntity=new UserEnt();
        }
        else{
            userEntity=userDao.findById(user.getId()).get();
        }
        userEntity=dtoToEnt(user, userEntity);
        userDao.save(userEntity);

    }

    private UserEnt dtoToEnt(UserDto dto, UserEnt ent) {
        if (dto == null) {
            return null;
        }
        if (ent == null) {
            throw new IllegalArgumentException("Argument ent can not be null");
        }
        //ent.setId(dto.getId());
        ent.setFirstName(dto.getFirstName());
        ent.setLastName(dto.getLastName());
        ent.setEmail(dto.getEmail());
        ent.setPassword(passwordEncoder.encode(dto.getPassword()));
        ent.setPicture(dto.getPicture());
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
