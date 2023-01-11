package com.siit.hospital_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("message", "Hospital Manager v1");
        return "index";
    }

}
