package com.tieto.bookyourshelf.library.dao;

import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowDao extends JpaRepository<BorrowEnt, Long> {

    List<BorrowEnt> findAll();

    BorrowEnt save(BorrowEnt borrow);
    Optional<BorrowEnt> findById(Integer id);
    BorrowEnt findBorrowEntByIdUser(Long idUser);

}
