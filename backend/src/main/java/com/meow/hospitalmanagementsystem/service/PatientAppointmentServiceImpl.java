package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.PatientAppointmentRequestDTO;
import com.meow.hospitalmanagementsystem.dto.PatientAppointmentResponseDTO;
import com.meow.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.meow.hospitalmanagementsystem.mapper.PatientAppointmentMapper;
import com.meow.hospitalmanagementsystem.repo.PatientAppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientAppointmentServiceImpl implements PatientAppointmentService {

    private final PatientAppointmentRepository patientAppointmentRepository;

    public PatientAppointmentServiceImpl(PatientAppointmentRepository patientAppointmentRepository) {
        this.patientAppointmentRepository = patientAppointmentRepository;
    }

    @Override
    public ResponseEntity<List<PatientAppointmentResponseDTO>> getAllPatientAppointments() {
        boolean isEmpty = patientAppointmentRepository.findAll().isEmpty();

        if (isEmpty) {
            throw new ResourceNotFoundException("PatientAppointment", "List empty");
        }

        List<PatientAppointmentResponseDTO> patientAppointmentResponseDTOList = patientAppointmentRepository.findAll().stream().map(PatientAppointmentMapper::toPatientAppointmentResponseDTO).toList();
        return ResponseEntity.ok(patientAppointmentResponseDTOList);
    }

    @Override
    public ResponseEntity<PatientAppointmentResponseDTO> getPatientAppointmentById(Long patientAppointmentId) {
        return null;
    }

    @Override
    public ResponseEntity<PatientAppointmentResponseDTO> createPatientAppointment(PatientAppointmentRequestDTO patientAppointmentRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<PatientAppointmentResponseDTO> updatePatientAppointment(Long patientAppointmentId, PatientAppointmentRequestDTO patientAppointmentRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deletePatientAppointment(Long patientAppointmentId) {
        return null;
    }
}
