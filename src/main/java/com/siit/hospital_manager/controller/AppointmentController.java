package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.dto.AppointmentDto;
import com.siit.hospital_manager.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/findAllByPatient")
    public String findAllByPatient(Model model, Principal principal) {
        List<AppointmentDto> appointments = appointmentService.findAllByUserName(principal.getName());
        model.addAttribute("appointments", appointments);

        return "appointment/viewAll";
    }

}
