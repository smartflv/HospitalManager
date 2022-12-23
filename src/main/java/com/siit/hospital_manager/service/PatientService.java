package com.siit.hospital_manager.service;

import com.siit.hospital_manager.exception.BusinessException;
import com.siit.hospital_manager.model.Patient;
import com.siit.hospital_manager.model.dto.*;
import com.siit.hospital_manager.repository.PatientJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientJpaRepository patientJpaRepository;

    public PatientService(PatientJpaRepository patientJpaRepository) {
        this.patientJpaRepository = patientJpaRepository;
    }

    public List<PatientDto> findAll() {
        return patientJpaRepository.findAll()
                .stream()
                .map(PatientDto::new).toList();
    }

    public PatientDto findById(Integer id) {
        Patient patient = patientJpaRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Patient with id " + id + " not found"));
        return new PatientDto(patient);
    }

    public void createPatient(CreatePatientDto createPatientDto) {
        patientJpaRepository.save(new Patient(createPatientDto));
    }

    public void updatePatient(UpdatePatientDto updatePatientDto) {
        Patient patient = patientJpaRepository
                .findById(updatePatientDto.getId())
                .orElseThrow(() -> new BusinessException(HttpStatus.BAD_REQUEST, "Patient with id " + updatePatientDto.getId() + " not found"));

        if (updatePatientDto.getAge() != null) {
            patient.setAge(updatePatientDto.getAge());
        }
        patientJpaRepository.save(patient);
    }

    // same for delete
}
