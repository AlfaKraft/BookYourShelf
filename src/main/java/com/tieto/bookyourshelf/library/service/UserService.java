package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.EmailExistsException;
import com.tieto.bookyourshelf.library.UserAlreadyExistException;
import com.tieto.bookyourshelf.library.dao.entityes.UserEnt;
import com.tieto.bookyourshelf.library.service.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserEnt saveUser(UserDto user)throws UserAlreadyExistException;
    UserEnt editUser(UserDto user);


}
