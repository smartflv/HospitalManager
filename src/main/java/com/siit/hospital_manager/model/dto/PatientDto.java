package com.siit.hospital_manager.model.dto;

import com.siit.hospital_manager.model.Patient;
import lombok.Data;

@Data
public class PatientDto {
    private Integer id;
    private String name;
    private Integer age;
    private String treatmentPlan;
    private String medicalHistory;

    public PatientDto(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.age = patient.getAge();
        this.treatmentPlan = patient.getTreatmentPlan();
        this.medicalHistory = patient.getMedicalHistory();
    }


    public String getMedicalHistory() {
        return this.medicalHistory;
    }
    public String getTreatmentPlan() {
        return this.treatmentPlan;
    }
}
