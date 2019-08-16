package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.service.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    void saveUser(UserDto user);

}
