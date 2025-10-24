package com.meow.hospitalmanagementsystem.dto;

import lombok.Data;

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
