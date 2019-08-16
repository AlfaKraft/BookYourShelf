package com.tieto.bookyourshelf.library.frontend;

import java.security.Principal;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String index(Model model, Principal principal) {

        /*String encoded=new BCryptPasswordEncoder().encode("1");
        System.out.println(encoded);*/


        model.addAttribute("message", "You are logged in as " + principal.getName());
        return "index";
    }

    /*public static void main(String[] args) {
        String encoded=new BCryptPasswordEncoder().encode("1");
        System.out.println(encoded);
    }*/
}
