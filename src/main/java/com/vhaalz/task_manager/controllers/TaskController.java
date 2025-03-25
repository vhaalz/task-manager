package com.vhaalz.task_manager.controllers;

import com.vhaalz.task_manager.models.Task;
import com.vhaalz.task_manager.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    private String home(){
        return "Home!!!";
    }

//    @GetMapping("/all")
//    private List<User> getAllUsers(){
//        return repo.findAll();
//    }

    @PostMapping("/")
    private ResponseEntity<Task> createTask(@RequestBody Task task){

        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }

}
