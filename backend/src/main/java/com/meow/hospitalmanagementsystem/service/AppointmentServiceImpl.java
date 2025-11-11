package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.AppointmentRequestDTO;
import com.meow.hospitalmanagementsystem.dto.AppointmentResponseDTO;
import com.meow.hospitalmanagementsystem.exception.InvalidRequestException;
import com.meow.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.meow.hospitalmanagementsystem.mapper.AppointmentMapper;
import com.meow.hospitalmanagementsystem.model.Appointment;
import com.meow.hospitalmanagementsystem.repo.AppointmentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepo appointmentRepo;

    public AppointmentServiceImpl(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public ResponseEntity<List<AppointmentResponseDTO>> getAppointments() {

        boolean exists = appointmentRepo.findAll().isEmpty();

        if (exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "List empty");
        }

        List<AppointmentResponseDTO> appointments = appointmentRepo.findAll().stream().map(AppointmentMapper::toAppointmentResponseDTO).toList();
        return ResponseEntity.ok(appointments);
    }

    @Override
    public ResponseEntity<AppointmentResponseDTO> getAppointmentById(Long id) {
        Appointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", id));
        return ResponseEntity.ok(AppointmentMapper.toAppointmentResponseDTO(appointment));
    }

    @Override
    public ResponseEntity<AppointmentResponseDTO> createAppointment(AppointmentRequestDTO appointment) {

        boolean exists = appointmentRepo.existsById(appointment.getAppointmentId());

        if (exists) {
            throw new InvalidRequestException("Appointment already exists!");
        }

        Appointment savedAppointment = appointmentRepo.save(AppointmentMapper.toAppointment(appointment));
        return ResponseEntity.ok(AppointmentMapper.toAppointmentResponseDTO(savedAppointment));
    }

    @Override
    public ResponseEntity<AppointmentResponseDTO> updateAppointment(AppointmentRequestDTO appointment) {

        boolean exists = appointmentRepo.existsById(appointment.getAppointmentId());

        if (!exists) {
            throw new InvalidRequestException("Appointment doesn't exist!");
        }

        Appointment updatedAppointment = appointmentRepo.save(AppointmentMapper.toAppointment(appointment));
        return ResponseEntity.ok(AppointmentMapper.toAppointmentResponseDTO(updatedAppointment));
    }

    @Override
    public ResponseEntity<String> deleteAppointment(Long id) {

        boolean exists = appointmentRepo.existsById(id);

        if (!exists) {
            throw new InvalidRequestException("Appointment doesn't exist!");
        }

        appointmentRepo.deleteById(id);
        return ResponseEntity.ok("Appointment deleted!");
    }
}
