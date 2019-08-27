package com.tieto.bookyourshelf.library.frontend;

import com.tieto.bookyourshelf.library.service.UserService;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private String userFirstName;

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

    @RequestMapping(value = "user/edit", method = RequestMethod.GET)
    public ModelAndView addUser() {
        UserDto user = new UserDto();
        return new ModelAndView("editUser", "user", user);
    }

    @RequestMapping(value = "user/save", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute UserDto user) {
        userService.saveUser(user);
        return new ModelAndView("users", "users", userService.getAllUsers());
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
    @RequestMapping(value = "include/header", method = RequestMethod.GET)
    public ModelAndView loadAccountName() {
        try {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String email = auth.getName();
            UserDto account = userService.getUserByEmail(email);
            System.out.println(account +"-------------------------------------------------------------------------------------------------------->");
            return new ModelAndView("include/header", "account", account);
        } catch (RuntimeException e) {
            throw e;
        }


    }


    @RequestMapping(value="user/faceRecognition", method = RequestMethod.GET)
    public ModelAndView fr(){
        return new ModelAndView("faceRecognition");
    }

    @RequestMapping(value="user/uploadImage", method=RequestMethod.POST)
    public String uploadImage(@RequestParam("imageBase64") String file) throws IOException {
        String userEmail= userService.faceRecognition(file);
        if(userEmail==null || userEmail==""){

        }
        else{
            Authentication authentication = new UsernamePasswordAuthenticationToken(userEmail, null,
                    AuthorityUtils.createAuthorityList("ROLE_USER"));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        return "redirect:/";
    }
}
