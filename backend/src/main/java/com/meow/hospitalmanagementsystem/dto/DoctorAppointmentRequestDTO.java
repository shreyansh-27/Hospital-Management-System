package com.meow.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAppointmentRequestDTO {
    private long doctorAppointmentId;
    private String observations;
    private String diagnosis;
    private String notes;
    private long appointmentId;
    private long doctorId;
}
