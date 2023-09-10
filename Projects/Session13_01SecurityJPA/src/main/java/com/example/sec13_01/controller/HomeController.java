package com.example.sec13_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/letgo")
public class HomeController {

    @GetMapping()
    public String showHomePage(Model model){
        return "home";
    }

}
