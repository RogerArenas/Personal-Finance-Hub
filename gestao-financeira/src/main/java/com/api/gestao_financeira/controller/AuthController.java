package com.api.gestao_financeira.controller;

import com.api.gestao_financeira.model.UserSecurity;
import com.api.gestao_financeira.repository.UserRepository;
import com.api.gestao_financeira.service.AuthService;
import com.api.gestao_financeira.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private final AuthService authService;


    private final UserRepository userRepository;


    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, UserRepository userRepository, JwtUtil jwtUtil) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest request) {
        authService.registerUser(request.getUsername(), request.getPassword(), request.getName(), request.getMail());

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        Optional<UserSecurity> userSecurity = authService.findByUsername(request.getUsername());
        if (userSecurity.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");

        }
        return ResponseEntity.ok("Login successful");
    }
}