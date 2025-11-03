package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.PatientRequestDTO;
import com.meow.hospitalmanagementsystem.dto.PatientResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PatientService {

    ResponseEntity<List<PatientResponseDTO>> getAllPatients();

    ResponseEntity<PatientResponseDTO> getPatientById(Long patientId);

    ResponseEntity<PatientResponseDTO> addPatient(PatientRequestDTO patientDTO);

    ResponseEntity<PatientResponseDTO> updatePatient(PatientRequestDTO patientRequestDTO, Long id);

    ResponseEntity<String> deletePatient(Long patientId);

    ResponseEntity<byte[]> getImageByPatientId(Long patientId);

    ResponseEntity<String> addOrUploadImage(MultipartFile file, Long patientId) throws IOException;
}
