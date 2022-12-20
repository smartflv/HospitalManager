package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.dto.CreatePatientDto;
import com.siit.hospital_manager.model.dto.PatientDto;
import com.siit.hospital_manager.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDto> findAll(){
        return patientService.findAll();
    }

    @PostMapping
    public void createPatient(@RequestBody CreatePatientDto createPatientDto){
        patientService.createPatient(createPatientDto);
    }
//      http://localhost:8080/patients/id?id=49480890-4a52-4d36-b476-cfa64232d0b5
//      http://localhost:8080/patients/49480890-4a52-4d36-b476-cfa64232d0b5
//    @GetMapping("/id")
//    public Patient findById(@RequestParam("id") Integer id) {
//        return patientService.findById(id);
//    }

    @GetMapping("{id}")
    public PatientDto findById(@PathVariable("id") Integer id) {
        return patientService.findById(id);
    }



}
