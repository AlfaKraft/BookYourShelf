package com.tieto.bookyourshelf.library.dao;

import com.tieto.bookyourshelf.library.dao.entityes.UserEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDao extends JpaRepository<UserEnt, String> {
    UserEnt findByEmail(String email);
}