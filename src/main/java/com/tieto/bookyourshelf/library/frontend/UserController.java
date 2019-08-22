package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.service.UserService;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

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

    @RequestMapping(value="user/edit", method = RequestMethod.GET)
    public ModelAndView addUser(){
        UserDto user=new UserDto();
        return new ModelAndView("editUser","user",user);
    }

    @RequestMapping(value="user/save", method=RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute UserDto user){
        userService.saveUser(user);
        return new ModelAndView("users","users", userService.getAllUsers());
    }



}