package com.example.event.eventbooking.controller;

import com.example.event.eventbooking.model.Role;
import com.example.event.eventbooking.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> request) {
        String token = userService.register(
                request.get("name"),
                request.get("email"),
                request.get("password"),
                Role.valueOf(request.get("role").toUpperCase()) // "USER" or "ADMIN"
        );
        return Map.of("token", token);
    }
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String token = userService.login(
                request.get("email"),
                request.get("password")
        );
        return Map.of("token", token);
    }
}
