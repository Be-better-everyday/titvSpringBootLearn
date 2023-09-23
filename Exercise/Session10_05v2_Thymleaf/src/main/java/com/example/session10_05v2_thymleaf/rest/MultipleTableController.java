package com.example.session10_05v2_thymleaf.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MultipleTableController {
    @GetMapping("/show/{x}")
    public String showTable(@PathVariable int x, Model model){
        model.addAttribute("number", x);
        return "multipleTable";
    }

    @GetMapping("show2/{number}")
    public String showMultipleTable(@PathVariable int number, Model model){
        model.addAttribute("number", number);
        return "multiTable2";
    }
}
