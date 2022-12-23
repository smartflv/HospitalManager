package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.Appointment;
import com.siit.hospital_manager.repository.AppointmentsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {

    public AppointmentsController(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    private final AppointmentsRepository appointmentsRepository;
    @GetMapping("/patient/{id}")
    public List<Appointment> getByPatientId(@PathVariable("id") Integer id){
       return appointmentsRepository.findAllByPatientId(id);
    }

}
