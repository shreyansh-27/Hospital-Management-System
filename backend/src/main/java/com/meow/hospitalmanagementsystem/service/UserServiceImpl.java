package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.UserRequestDTO;
import com.meow.hospitalmanagementsystem.dto.UserResponseDTO;
import com.meow.hospitalmanagementsystem.mapper.UserMapper;
import com.meow.hospitalmanagementsystem.model.User;
import com.meow.hospitalmanagementsystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<UserResponseDTO> saveUser(UserRequestDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepo.save(UserMapper.toUser(user));
        return ResponseEntity.ok(UserMapper.toUserDto(savedUser));
    }


}
