package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.PatientRequestDTO;
import com.meow.hospitalmanagementsystem.dto.PatientResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class PatientServiceImpl implements PatientService{
    @Override
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return null;
    }

    @Override
    public ResponseEntity<PatientResponseDTO> getPatientById(Long patientId) {
        return null;
    }

    @Override
    public ResponseEntity<PatientRequestDTO> addPatient(PatientRequestDTO patientDTO) {
        return null;
    }

    @Override
    public ResponseEntity<PatientRequestDTO> updatePatient(PatientRequestDTO patientRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deletePatient(Long patientId) {
        return null;
    }
}
