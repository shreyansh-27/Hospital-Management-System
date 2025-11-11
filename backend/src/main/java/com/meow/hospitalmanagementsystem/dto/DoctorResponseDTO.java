package com.meow.hospitalmanagementsystem.dto;

import java.util.List;

public record DoctorResponseDTO(
        Long id,
        String medicalLicense,
        String firstName,
        String lastName,
        String specialization,
        int experience,
        String qualification,
        AddressDTO address,
        String phone,
        List<Long> doctorAppointmentsIds
) {
}
