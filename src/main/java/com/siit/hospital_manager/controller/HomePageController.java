package com.siit.hospital_manager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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

    @GetMapping("/dashboard")
    public String dashBoard(Model model, Authentication authentication){
        model.addAttribute("userName", authentication.getName());
        model.addAttribute("isAdmin", isAdmin(authentication));
        model.addAttribute("isPatient", isPatient(authentication));
        model.addAttribute("isDoctor", isDoctor(authentication));


        model.addAttribute("message", "Hospital Manager v1");
        return "dashboard/dashboard";
    }

    private boolean isAdmin(Authentication authentication){
        return authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList().contains("ROLE_ADMIN");
    }

    private boolean isPatient(Authentication authentication){
        return authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList().contains("ROLE_PATIENT");
    }

    private boolean isDoctor(Authentication authentication){
        return authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList().contains("ROLE_DOCTOR");
    }

}
