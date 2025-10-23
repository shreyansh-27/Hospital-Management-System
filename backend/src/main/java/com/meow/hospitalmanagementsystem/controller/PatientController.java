package com.meow.hospitalmanagementsystem.controller;

import com.meow.hospitalmanagementsystem.dto.CreatePatientDTO;
import com.meow.hospitalmanagementsystem.dto.PatientResponseDTO;
import com.meow.hospitalmanagementsystem.model.Patient;
import com.meow.hospitalmanagementsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable Long patientId){
        return patientService.getPatientById(patientId);
    }

    @PostMapping()
    public ResponseEntity<CreatePatientDTO> addPatient(@RequestBody CreatePatientDTO patientDTO){
        return patientService.addPatient(patientDTO);
    }
}
