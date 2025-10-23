package com.meow.hospitalmanagementsystem.dto;

public record PatientResponseDTO(
        Long id,
        String fname,
        String mname,
        String lname,
        String email,
        String phone,
        String bloodGroup,
        AddressDTO addressDTO
        ) {

}
