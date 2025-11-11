package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.PatientAppointmentRequestDTO;
import com.meow.hospitalmanagementsystem.dto.PatientAppointmentResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientAppointmentService {
    public ResponseEntity<List<PatientAppointmentResponseDTO>> getAllPatientAppointments();

    public ResponseEntity<PatientAppointmentResponseDTO> getPatientAppointmentById(Long patientAppointmentId);

    public ResponseEntity<PatientAppointmentResponseDTO> createPatientAppointment(PatientAppointmentRequestDTO patientAppointmentRequestDTO);

    public ResponseEntity<PatientAppointmentResponseDTO> updatePatientAppointment(Long patientAppointmentId, PatientAppointmentRequestDTO patientAppointmentRequestDTO);

    public ResponseEntity<String> deletePatientAppointment(Long patientAppointmentId);
}
