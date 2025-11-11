package com.meow.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDTO {

    private String medicalLicense;
    private String firstName;
    private String lastName;
    private String specialization;
    private int experience;
    private String qualification;
    private AddressRequestDTO address;
    private String phone;
    private List<Long> doctorAppointments;
}
