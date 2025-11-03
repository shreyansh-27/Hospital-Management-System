package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.UserRequestDTO;
import com.meow.hospitalmanagementsystem.dto.UserResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
  ResponseEntity<UserResponseDTO> saveUser(UserRequestDTO user);
}
