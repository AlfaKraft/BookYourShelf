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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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

    @Override
    public List<BorrowDto>   getBorrowsByIdUser(Long idUser){
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
    public BorrowDto getBorrowedBookByIdBook(Long idBook) {
        BorrowDto borrowDto;
        try {
            BorrowEnt borrowEnt = borrowDao.findBorrowEntByIdBookAndDateBrought(idBook, null);
            borrowDto = entToDto(borrowEnt, null);

        } catch (Exception e){
            throw new LibraryException(e.getMessage(), e);
        }
        return borrowDto;
    }

    @Override
    public void deleteByBookId(Long id) {
        List<BorrowEnt> borrows = borrowDao.findAllByIdBook(id);
        if(!borrows.isEmpty()){
            for (int i = 0; i < borrows.size(); i++){
                borrowDao.deleteById(borrows.get(i).getId());
            }
        }
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
    public void addBorrow(BorrowEnt borrow){
        try{
            borrowDao.save(borrow);
        } catch (Exception e){
            throw new LibraryException(e.getMessage(), e);
        }
    }

    private BorrowEnt dtoToEnt(BorrowEnt dto, BorrowEnt ent){

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
        String foramttedDate;
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
        if(ent.getDateBrought() != null){
            foramttedDate = ent.getDateBrought().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
            dto.setDateBrought(foramttedDate);

        }

        if(ent.getDateToBring() != null){
            SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd. MMM yyyy");

            dto.setDateToBring(formatter.format(ent.getDateToBring()));
        }
        foramttedDate = ent.getDateTaken().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        dto.setDateTaken(foramttedDate);



        return dto;

    }
}