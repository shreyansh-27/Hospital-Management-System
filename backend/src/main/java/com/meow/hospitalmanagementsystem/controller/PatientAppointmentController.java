package com.meow.hospitalmanagementsystem.controller;

import com.meow.hospitalmanagementsystem.dto.PatientAppointmentRequestDTO;
import com.meow.hospitalmanagementsystem.dto.PatientAppointmentResponseDTO;
import com.meow.hospitalmanagementsystem.service.PatientAppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient-appointments")
public class PatientAppointmentController {

    private final PatientAppointmentService patientAppointmentService;

    public PatientAppointmentController(PatientAppointmentService patientAppointmentService) {
        this.patientAppointmentService = patientAppointmentService;
    }

    @GetMapping
    public ResponseEntity<List<PatientAppointmentResponseDTO>> getAllPatientAppointments() {
        return patientAppointmentService.getAllPatientAppointments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientAppointmentResponseDTO> getPatientAppointmentById(Long id) {
        return patientAppointmentService.getPatientAppointmentById(id);
    }

    @PostMapping
    public ResponseEntity<PatientAppointmentResponseDTO> createPatientAppointment(@RequestBody PatientAppointmentRequestDTO dto) {
        return patientAppointmentService.createPatientAppointment(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientAppointmentResponseDTO> updatePatientAppointment(@PathVariable Long id, @RequestBody PatientAppointmentRequestDTO dto) {
        return patientAppointmentService.updatePatientAppointment(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientAppointment(@PathVariable Long id) {
        return patientAppointmentService.deletePatientAppointment(id);
    }
}
