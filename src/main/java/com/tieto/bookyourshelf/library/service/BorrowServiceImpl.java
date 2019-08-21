package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.LibraryException;
import com.tieto.bookyourshelf.library.dao.BorrowDao;
import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {


    @Autowired

    private BorrowDao borrowDao;


    @Override
    public List<BorrowDto> getAllBorrows() {
        List<BorrowDto> ret;
        try {
            List<BorrowEnt> ent = borrowDao.findAll();
            ret = ent.stream().map(e -> entToDto(e, null)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new LibraryException(e.getMessage(), e);
        }
        return ret;
    }


    @Override
    public BorrowDto getBorrowsById(Long Id) {
        Optional<BorrowEnt> borrow=borrowDao.findById(Id);
        if(borrow.isEmpty()) {
            return null;
        }
        return entToDto(borrow.get(), null);
    }
    /*
    @Override
    public BorrowDto getBorrowsByIdUser(Long idUser){
        Optional<BorrowEnt> borrow=borrowDao.findById(idUser);
        if(borrow.isEmpty()){
            return null;
        }
        return entToDto(borrow.get(), null);
    }
*/

    @Override
    public BorrowDto getBorrowsByIdUser(Long idUser) {
        BorrowEnt borrow = borrowDao.findBorrowEntByIdUser(idUser);
        return entToDto(borrow, null);
    }



    @Override
    public BorrowDto getBorrowsByIdBook(Long idBook) {
        BorrowEnt borrow = borrowDao.findBorrowEntByIdBook(idBook);
        return entToDto(borrow, null);
    }


    @Override
    public BorrowDto getBorrowsByDateTaken(Date dateTaken) {
        BorrowEnt borrow = borrowDao.findBorrowEntByDateTaken(dateTaken);
        return entToDto(borrow, null);
    }


    @Override
    public BorrowDto getBorrowsByDateToBring(Date dateToBring) {
        BorrowEnt borrow = borrowDao.findBorrowEntByDateTaken(dateToBring);
        return entToDto(borrow, null);
    }

    @Override
    public BorrowDto getBorrowsByDateBrought(Date dateBrought) {
        BorrowEnt borrow = borrowDao.findBorrowEntByDateTaken(dateBrought);
        return entToDto(borrow, null);
    }

    @Override
    public List<BorrowDto> loadBorrows() {
        return null;
    }

    @Override
    public BorrowDto loadById(Integer id) {
        return null;
    }

    @Override
    public void addBorrow(BorrowDto borrow) {
        BorrowEnt ent;
        try{
            ent = new BorrowEnt();
            ent = dtoToEnt(borrow, ent);
            borrowDao.save(ent);

        } catch (Exception e){
            throw new LibraryException(e.getMessage(), e);
        }
    }


    private BorrowEnt dtoToEnt(BorrowDto dto, BorrowEnt ent){
        if (dto == null) {
            return null;
        }
        if (ent == null) {
            throw new IllegalArgumentException("Argument ent can not be null");
        }
        ent.setId(dto.getId());
        ent.setIdUser(dto.getIdUser());
        ent.setIdBook(dto.getIdBook());
        ent.setDateTaken(dto.getDateTaken());
        ent.setDateToBring(dto.getDateToBring());
        ent.setDateBrought(dto.getDateBrought());

        return ent;
    }
    private BorrowDto entToDto(BorrowEnt ent, BorrowDto dto) {
        if (ent == null) {
            return null;
        }
        if (dto == null) {
            dto = new BorrowDto();
        }

        dto.setId(ent.getId());
        dto.setIdUser(ent.getIdUser());
        dto.setIdBook(ent.getIdBook());
        dto.setDateTaken(ent.getDateTaken());
        dto.setDateToBring(ent.getDateToBring());
        dto.setDateBrought(ent.getDateBrought());

        return dto;

    }
}
