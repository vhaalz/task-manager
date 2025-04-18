package com.vhaalz.task_manager.controllers;

import com.vhaalz.task_manager.dto.LoginRequest;
import com.vhaalz.task_manager.dto.RegisterRequest;
import com.vhaalz.task_manager.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

   private final AuthService service;

    @PostMapping("/register")
    private ResponseEntity<UUID> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(request));
    }

    @PostMapping("/login")
    private String login(@Valid @RequestBody LoginRequest request){
        return service.verify(request);
    }

}
