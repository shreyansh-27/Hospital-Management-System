package com.meow.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientAppointmentRequestDTO {
    private int patientAppointmentId;
    private Long patientId;
    private Long appointmentId;
    private String reportedSymptoms;
}
