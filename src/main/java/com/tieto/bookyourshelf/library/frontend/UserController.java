package com.tieto.bookyourshelf.library.frontend;

import com.mysql.cj.protocol.Message;
import com.tieto.bookyourshelf.library.EmailExistsException;
import com.tieto.bookyourshelf.library.UserAlreadyExistException;
import com.tieto.bookyourshelf.library.dao.entityes.UserEnt;
import com.tieto.bookyourshelf.library.service.UserService;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.ui.Model;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView loadAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ModelAndView("users", "users", users);
    }

    @RequestMapping(value = "user/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return new ModelAndView("editUser", "user", user);
    }

    @RequestMapping(value="user/registration", method = RequestMethod.GET)
    public ModelAndView addUser(){
        UserDto user=new UserDto();

        return new ModelAndView("addUser","user",user);
    }

    @RequestMapping(value="user/save", method=RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute ("user") @Valid UserDto user, BindingResult br){

        if (br.hasErrors()) {
            //log.error("error -"+br.getAllErrors().get(0).toString());
            return new ModelAndView("addUser");
        } else {
            try {
                    user.setRole("USER");
                    userService.saveUser(user);
                    return new ModelAndView("users","users", userService.getAllUsers());
                } catch (UserAlreadyExistException e) {
                    br.rejectValue("email", "email.alreadyexists", "A user with that email already exists");
                    return new ModelAndView("addUser");
                }
        }
    }

    @RequestMapping(value = "user/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/app/users/remove";
    }

    @RequestMapping(value = "users/remove", method = RequestMethod.GET)
    public ModelAndView loadRemoveUsersView(Model model) {
        try {
            return new ModelAndView("removeUsersView", "list", userService.getAllUsers());

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @RequestMapping(value = "account", method = RequestMethod.GET)
    public ModelAndView loadAccountDetails() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = auth.getName();
            UserDto account = userService.getUserByEmail(email);
            return new ModelAndView("account", "details", account);
        } catch (RuntimeException e) {
            throw e;
        }


    }
    @ModelAttribute
    public void addAttributes(Model model){
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = auth.getName();
            UserDto account = userService.getUserByEmail(email);
            model.addAttribute("account", account);
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
