package com.meow.hospitalmanagementsystem.controller;

import com.meow.hospitalmanagementsystem.dto.PatientRequestDTO;
import com.meow.hospitalmanagementsystem.dto.PatientResponseDTO;
import com.meow.hospitalmanagementsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {


    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable Long patientId) {
        return patientService.getPatientById(patientId);
    }

    @GetMapping("/{patientId}/image")
    public ResponseEntity<byte[]> getPatientImage(@PathVariable Long patientId) {
        return patientService.getImageByPatientId(patientId);
    }

    @PostMapping("/{patientId}/image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file, @PathVariable Long patientId) throws IOException {
        return patientService.addOrUploadImage(file, patientId);
    }

    @PutMapping("/{patientId}/image")
    public ResponseEntity<String> updateImage(@RequestParam("image") MultipartFile file,
                                              @PathVariable Long patientId) throws IOException {
        return patientService.addOrUploadImage(file, patientId);
    }

    @PostMapping()
    public ResponseEntity<PatientResponseDTO> addPatient(@RequestBody PatientRequestDTO patientDTO) {
        return patientService.addPatient(patientDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@RequestBody PatientRequestDTO patientRequestDTO, @PathVariable Long id) {
        return patientService.updatePatient(patientRequestDTO, id);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
        return patientService.deletePatient(patientId);
    }
}
