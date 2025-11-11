package com.meow.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequestDTO {
    private Long appointmentId;
    private List<Long> patientIds;
    private List<Long> doctorIds;
    private LocalDateTime appointmentDateTime;
    private String appointmentStatus;
}
