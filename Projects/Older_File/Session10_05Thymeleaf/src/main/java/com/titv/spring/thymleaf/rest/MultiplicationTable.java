package com.titv.spring.thymleaf.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MultiplicationTable {
    @GetMapping("/display/{x}")
    public String showTable(@PathVariable int x, Model model){
        model.addAttribute("number", x);
        //return file file name Thymeleaf
        return "bang-cuu-chuong";
    }
}
