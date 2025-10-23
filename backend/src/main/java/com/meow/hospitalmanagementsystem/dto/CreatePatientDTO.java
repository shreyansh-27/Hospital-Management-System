package com.meow.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientDTO {
    public String firstName;
    public String middleName;
    public String lastName;
    public String email;
    public String phone;
    public String dateOfBirth;
    public String role;
}
