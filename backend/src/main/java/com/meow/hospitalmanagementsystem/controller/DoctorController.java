package com.meow.hospitalmanagementsystem.controller;

import com.meow.hospitalmanagementsystem.dto.DoctorRequestDTO;
import com.meow.hospitalmanagementsystem.dto.DoctorResponseDTO;
import com.meow.hospitalmanagementsystem.service.DoctorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

  @Autowired private DoctorService doctorService;

  @GetMapping
  public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
    return doctorService.getAllDoctors();
  }

  @GetMapping("/{id}")
  public ResponseEntity<DoctorResponseDTO> getDoctor(@PathVariable Long id) {
    return doctorService.getDoctorById(id);
  }

  @PostMapping()
  public ResponseEntity<DoctorResponseDTO> saveDoctor(@RequestBody DoctorRequestDTO dto) {
      return doctorService.saveDoctor(dto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<DoctorResponseDTO> updateDoctor(@PathVariable Long id, @RequestBody DoctorRequestDTO dto){
      return doctorService.updateDoctorById(id, dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteDoctor(@PathVariable Long id){
      return doctorService.deleteDoctorById(id);
  }
}
