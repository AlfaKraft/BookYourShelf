package com.tieto.bookyourshelf.library.dao;

import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowDao extends JpaRepository<BorrowEnt, Long> {

    List<BorrowEnt> findAll();

    BorrowEnt save(BorrowEnt borrow);
    Optional<BorrowEnt> findById(Long id);
    List<BorrowEnt> findAllByIdUser(Long id);
    BorrowEnt findBorrowEntByIdUser(Long idUser);
    BorrowEnt findBorrowEntByIdBook(Long id);
    BorrowEnt findBorrowEntByIdBookAndDateBrought(Long idBook, LocalDate dateBrought);
    BorrowEnt findBorrowEntByDateTaken(LocalDate dateTaken);
    BorrowEnt findBorrowEntByDateToBring(Date dateToBring);
    BorrowEnt findBorrowEntByDateBrought(LocalDate dateBrought);
    List<BorrowEnt> findAllByIdBook(Long id);



    List<BorrowEnt> findBorrowEntByDateToBringBeforeAndDateBroughtIsNull(Date localDate);



}
