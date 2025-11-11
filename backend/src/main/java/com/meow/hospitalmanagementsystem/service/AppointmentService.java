package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.AppointmentRequestDTO;
import com.meow.hospitalmanagementsystem.dto.AppointmentResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentService {
    ResponseEntity<List<AppointmentResponseDTO>> getAppointments();

    ResponseEntity<AppointmentResponseDTO> getAppointmentById(Long id);

    ResponseEntity<AppointmentResponseDTO> createAppointment(AppointmentRequestDTO appointment);

    ResponseEntity<AppointmentResponseDTO> updateAppointment(AppointmentRequestDTO appointment);

    ResponseEntity<String> deleteAppointment(Long id);
}
