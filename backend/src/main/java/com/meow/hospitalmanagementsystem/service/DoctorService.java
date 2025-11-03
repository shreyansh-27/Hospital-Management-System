package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.DoctorRequestDTO;
import com.meow.hospitalmanagementsystem.dto.DoctorResponseDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface DoctorService {
  ResponseEntity<List<DoctorResponseDTO>> getAllDoctors();

  ResponseEntity<DoctorResponseDTO> getDoctorById(Long id);

  ResponseEntity<DoctorResponseDTO> saveDoctor(DoctorRequestDTO dto);

  ResponseEntity<DoctorResponseDTO> updateDoctorById(Long id, DoctorRequestDTO dto);

  ResponseEntity<String> deleteDoctorById(Long id);
}
