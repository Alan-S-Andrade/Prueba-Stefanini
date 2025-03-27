package com.example.userapi.controller;

import com.example.userapi.dto.AuthRequest;
import com.example.userapi.dto.AuthResponse;
import com.example.userapi.entity.User;
import com.example.userapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticación", description = "Endpoints para autenticación")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Operation(summary = "Iniciar sesión y obtener token JWT")
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }

    @Operation(summary = "Registrar nuevo usuario")
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.registerUser(user);
    }
}
