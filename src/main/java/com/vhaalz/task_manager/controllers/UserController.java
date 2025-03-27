package com.vhaalz.task_manager.controllers;

import com.vhaalz.task_manager.domain.LoginRequest;
import com.vhaalz.task_manager.domain.RegisterRequest;
import com.vhaalz.task_manager.models.User;
import com.vhaalz.task_manager.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

   private final UserService service;

    @PostMapping("/register")
    private ResponseEntity<Long> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(request));
    }

    @PostMapping("/login")
    private String login(@Valid @RequestBody LoginRequest request){
        return service.verify(request);
    }

}
