package com.meow.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    public String firstName;
    public String lastName;
    public String username;
    public String email;
    public String phone;
    public String password;
    public String role;
}
