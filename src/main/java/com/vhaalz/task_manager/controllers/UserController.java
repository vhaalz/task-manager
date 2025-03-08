package com.vhaalz.task_manager.controllers;

import com.vhaalz.task_manager.models.User;
import com.vhaalz.task_manager.services.UserService;
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
    private ResponseEntity<User> register(@RequestBody User user){

        User user1 = new User();

        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());

        service.register(user1);

        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @PostMapping("/login")
    private String login(@RequestBody User user){
        return service.verify(user);
    }

}
