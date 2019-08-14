package com.tieto.bookyourshelf.library.dao;


import com.tieto.bookyourshelf.library.dao.entityes.UserEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserEnt, Long> {
    List<UserEnt> findAll();
    UserEnt save(UserEnt user);
}
