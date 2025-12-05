package com.example.task_tracker.controller;

import com.example.task_tracker.dto.AuthRequest;
import com.example.task_tracker.model.User;
import com.example.task_tracker.security.JwtUtil;
import com.example.task_tracker.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    
    public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }
    
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody AuthRequest request) {
        userService.registerUser(request.getEmail(), request.getPassword());
        return Map.of("message", "User registered successfully");
    }
    
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());
        
        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }
        
        String token = jwtUtil.generateToken(user.getEmail());
        return Map.of("token", token);
    }
}
