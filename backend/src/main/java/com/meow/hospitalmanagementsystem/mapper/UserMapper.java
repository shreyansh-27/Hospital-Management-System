package com.meow.hospitalmanagementsystem.mapper;

import com.meow.hospitalmanagementsystem.dto.UserRequestDTO;
import com.meow.hospitalmanagementsystem.dto.UserResponseDTO;
import com.meow.hospitalmanagementsystem.model.Patient;
import com.meow.hospitalmanagementsystem.model.User;
import com.meow.hospitalmanagementsystem.model.enums.Role;

public class UserMapper {

    public static User toUser(UserRequestDTO userDTO) {
        User user = new Patient();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());
        user.setRole(Role.valueOf(userDTO.getRole()));
        return user;
    }

    public static UserResponseDTO toUserDto(User savedUser) {
        return new UserResponseDTO(savedUser.getUsername(), savedUser.getPassword());
    }

}
