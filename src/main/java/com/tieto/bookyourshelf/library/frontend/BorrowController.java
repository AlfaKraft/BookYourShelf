 package com.tieto.bookyourshelf.library.frontend;
import com.tieto.bookyourshelf.library.service.BorrowService;
import com.tieto.bookyourshelf.library.service.UserService;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@RestController
@Controller
public class BorrowController {

    @Autowired
    private BorrowService borrowService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/borrows", method = RequestMethod.GET)
    public ModelAndView getAllBorrows() {
        List<BorrowDto> borrows = borrowService.getAllBorrows();

        return new ModelAndView("borrows", "borrows", borrows );
    }



    @RequestMapping(value = "/history", method = RequestMethod.GET)
        public ModelAndView getUserBorrowsHistory(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        List<BorrowDto> borrowDtos = borrowService.getBorrowsByIdUser(userService.getUserByEmail(email).getId());

        return new ModelAndView("history", "borrows", borrowDtos);
    }



}

