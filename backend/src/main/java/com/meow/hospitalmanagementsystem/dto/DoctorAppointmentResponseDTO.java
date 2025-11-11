package com.meow.hospitalmanagementsystem.dto;

public record DoctorAppointmentResponseDTO
        (long id, String observations, String diagnosis, String notes, long doctorId, long appointmentId) {
}
