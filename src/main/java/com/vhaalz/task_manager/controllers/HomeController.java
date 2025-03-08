package com.vhaalz.task_manager.controllers;

import com.vhaalz.task_manager.models.User;
import com.vhaalz.task_manager.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {

    private final UserRepo repo;

    @GetMapping("/")
    private String home(){
        return "Home!!!";
    }

    @GetMapping("/all")
    private List<User> getAllUsers(){
        return repo.findAll();
    }


}
