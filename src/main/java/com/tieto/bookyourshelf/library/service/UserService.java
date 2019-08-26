package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.service.dto.UserDto;

import java.util.List;

public interface UserService {

    void deleteUser(Long id);

    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    void saveUser(UserDto user);
    UserDto getUserByEmail(String email);

}
