package com.meow.hospitalmanagementsystem.controller.AuthController;

import com.meow.hospitalmanagementsystem.dto.UserLoginRequestDTO;
import com.meow.hospitalmanagementsystem.dto.UserRequestDTO;
import com.meow.hospitalmanagementsystem.dto.UserResponseDTO;
import com.meow.hospitalmanagementsystem.service.UserService;
import com.meow.hospitalmanagementsystem.service.authService.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO user) {
        System.out.println("inside register");
        return service.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequestDTO user) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "login failed";
        }
    }
}
