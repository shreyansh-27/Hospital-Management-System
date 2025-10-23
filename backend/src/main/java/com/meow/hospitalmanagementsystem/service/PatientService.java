package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.PatientRequestDTO;
import com.meow.hospitalmanagementsystem.dto.PatientResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    ResponseEntity<List<PatientResponseDTO>> getAllPatients();

    ResponseEntity<PatientResponseDTO> getPatientById(Long patientId);

    ResponseEntity<PatientRequestDTO> addPatient(PatientRequestDTO patientDTO);

    ResponseEntity<PatientRequestDTO> updatePatient(PatientRequestDTO patientRequestDTO);

    ResponseEntity<String> deletePatient(Long patientId);
}
