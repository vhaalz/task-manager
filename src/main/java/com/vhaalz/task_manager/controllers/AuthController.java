package com.vhaalz.task_manager.controllers;

import com.vhaalz.task_manager.models.User;
import com.vhaalz.task_manager.repos.AuthRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthRepo repo;

    @PostMapping("/signup")
    private ResponseEntity<User> signUp(@RequestBody User user){
        User user1 = new User();

        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        repo.save(user1);

        return ResponseEntity.ok(user1);
    }

    @GetMapping("/all")
    private List<User> getAllUsers(){
        return repo.findAll();
    }
}
