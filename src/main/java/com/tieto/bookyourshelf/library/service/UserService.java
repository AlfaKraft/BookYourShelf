package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.frontend.models.User;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDto> loadUsers();
    void saveUser(UserDto user);
    UserDto loadById(Long id);
}
