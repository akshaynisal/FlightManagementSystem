package com.cts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        System.out.println("$$$$$$$$$$$$index$$$$$$$$$$$$$$$");

        return "index";
    }

   @GetMapping("/login")
    public String login(Model model) {
        System.out.println("$$$$$$$$$$$$$$login$$$$$$$$$$$$$$$$$$$");
        return "login";
    }


    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}