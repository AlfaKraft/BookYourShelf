package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.service.UserService;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

import java.util.List;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="users", method = RequestMethod.GET)
    public ModelAndView loadAllUsers(){
        List<UserDto> users=userService.getAllUsers();
        return new ModelAndView("users","users", users);
    }

    @RequestMapping(value="user/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable Long id){
        UserDto user=userService.getUserById(id);
        return new ModelAndView("editUser","user",user);
    }

    @RequestMapping(value="user/registration", method = RequestMethod.GET)
    public ModelAndView addUser(){
        UserDto user=new UserDto();
        return new ModelAndView("addUser","user",user);
    }

    @RequestMapping(value="user/save", method=RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute ("user") @Valid UserDto user, BindingResult br){
        if (br.hasErrors()) {
            log.error("error -"+br.getAllErrors().get(0).toString());
            return new ModelAndView("addUser");}

        else {
            userService.saveUser(user);
            //return new ModelAndView("books");
            return new ModelAndView("users","users", userService.getAllUsers());
        }
    }



}
