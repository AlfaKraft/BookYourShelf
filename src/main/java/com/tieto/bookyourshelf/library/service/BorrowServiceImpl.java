package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.LibraryException;
import com.tieto.bookyourshelf.library.dao.BookDao;
import com.tieto.bookyourshelf.library.dao.BorrowDao;
import com.tieto.bookyourshelf.library.dao.UserDao;
import com.tieto.bookyourshelf.library.dao.entityes.BookEnt;
import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.dao.entityes.UserEnt;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {


    @Autowired

    private BorrowDao borrowDao;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;


    @Override
    public List<BorrowDto> getAllBorrows() {
        List<BorrowDto> ret;
        System.out.println("1----------------------------------------------------------------------------------------------------------");
        try {
            List<BorrowEnt> ent = borrowDao.findAll();
            System.out.println("2----------------------------------------------------------------------------------------------------------");
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

    @Override
    public List<BorrowDto> getBorrowsByIdUser(Long idUser){
        List<BorrowDto> ret;

        try{
            List<BorrowEnt> borrows = borrowDao.findAllByIdUser(idUser);
            ret = borrows.stream().map(e -> entToDto(e, null)).collect(Collectors.toList());
        } catch (Exception e){
            throw new LibraryException(e.getMessage(), e);
        }

        return ret;
    }

    @Override
    public BorrowDto getBorrowsByIdBook(Long idBook) {
        BorrowEnt borrow = borrowDao.findBorrowEntByIdBook(idBook);
        return entToDto(borrow, null);
    }

    @Override
    public BorrowDto getBorrowsByDateTaken(LocalDate dateTaken) {
        return null;
    }

    @Override
    public BorrowDto getBorrowsByDateToBring(Date dateToBring) {
        return null;
    }

    @Override
    public BorrowDto getBorrowsByDateBrought(LocalDate dateBrought) {
        return null;
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
    public void addBorrow(BorrowEnt borrow) {

        try{

            borrowDao.save(borrow);

        } catch (Exception e){
            throw new LibraryException(e.getMessage(), e);
        }
    }
/*
    @Override
    public void addBrought(BorrowEnt borrow) {
        try {
            borrowDao.save(borrow);
        }   catch (Exception e) {
            throw new LibraryException(e.getMessage(),e);
        }
    }

 */

    private BorrowEnt dtoToEnt(BorrowDto dto, BorrowEnt ent){
        if (dto == null) {
            return null;
        }
        if (ent == null) {
            throw new IllegalArgumentException("Argument ent can not be null");
        }
        ent.setId(dto.getId());
        ent.setDateTaken(dto.getDateTaken());
        ent.setDateToBring(dto.getDateToBring());
        ent.setDateBrought(dto.getDateBrought());

        return ent;
    }
    private BorrowDto entToDto(BorrowEnt ent, BorrowDto dto) {
        System.out.println("3----------------------------------------------------------------------------------------------------------");
        if (ent == null) {
            return null;
        }
        if (dto == null) {
            dto = new BorrowDto();
        }

        dto.setId(ent.getId());
        try{
            UserDto userDto = userService.getUserById(ent.getIdUser());
            dto.setName(userDto.getFirstName() + " " + userDto.getLastName());

        }catch (Exception e){
            dto.setName("");
        }
        try{
            BookDto bookDto = bookService.getBookById(ent.getIdBook());
            dto.setTitle(bookDto.getTitle());
        }catch (Exception e){
            dto.setTitle("");
        }

        dto.setDateTaken(ent.getDateTaken());
        dto.setDateToBring(ent.getDateToBring());
        dto.setDateBrought(ent.getDateBrought());

        return dto;

    }
}
