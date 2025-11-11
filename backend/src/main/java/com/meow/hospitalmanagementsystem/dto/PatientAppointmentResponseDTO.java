package com.meow.hospitalmanagementsystem.dto;

public record PatientAppointmentResponseDTO(Long patientAppointmentId, Long patientId, Long appointmentId,
                                            String reportedSymptoms) {
}
