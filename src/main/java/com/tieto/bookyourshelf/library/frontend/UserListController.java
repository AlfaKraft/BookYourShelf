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
public class UserListController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "users/load", method = RequestMethod.GET)
    public ModelAndView loadUsers(){
        try{
            List<UserDto> model = userService.loadUsers();
            return new ModelAndView("users", "user", model);

        } catch (RuntimeException e){
            throw e;
        }
    }
    @RequestMapping(value="user/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long id) {
        UserDto model;
        if (id == null) {
            model = new UserDto();
        } else {
            model = userService.loadById(id);
        }
        return new ModelAndView("editUser", "user", model);
    }

    @RequestMapping(value="user/save", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute UserDto user) {
        try {
            userService.saveUser(user);
        } catch (RuntimeException e) {
            //log.error(e.getMessage(), e);
            throw e;
        }
        return new ModelAndView("users", "user", userService.loadUsers());
    }
}
