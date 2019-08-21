package com.tieto.bookyourshelf.library.dao;

import com.tieto.bookyourshelf.library.dao.entityes.UserEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEnt,Long> {

    List<UserEnt> findAll();
    UserEnt save(UserEnt user);
    Optional<UserEnt> findById(Integer id);
}
