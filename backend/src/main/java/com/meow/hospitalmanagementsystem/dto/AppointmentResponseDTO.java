package com.meow.hospitalmanagementsystem.dto;

import java.time.LocalDateTime;
import java.util.List;

public record AppointmentResponseDTO(Long appointmentId, List<Long> patientIds, List<Long> doctorIds,
                                     LocalDateTime appointmentDate, String appointmentStatus) {
}
