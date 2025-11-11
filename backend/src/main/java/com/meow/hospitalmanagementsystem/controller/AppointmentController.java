package com.meow.hospitalmanagementsystem.controller;

import com.meow.hospitalmanagementsystem.dto.AppointmentRequestDTO;
import com.meow.hospitalmanagementsystem.dto.AppointmentResponseDTO;
import com.meow.hospitalmanagementsystem.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointments() {
        return appointmentService.getAppointments();
    }

    @GetMapping
    public ResponseEntity<AppointmentResponseDTO> getAppointmentById(Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@RequestBody AppointmentRequestDTO appointment) {
        return appointmentService.createAppointment(appointment);
    }


    @PutMapping
    public ResponseEntity<AppointmentResponseDTO> updateAppointment(@RequestBody AppointmentRequestDTO appointment) {
        return appointmentService.updateAppointment(appointment);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAppointment(Long id) {
        return appointmentService.deleteAppointment(id);
    }

}
