package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String email);
}
