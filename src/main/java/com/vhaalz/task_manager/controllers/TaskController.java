package com.vhaalz.task_manager.controllers;

import com.vhaalz.task_manager.domain.CreateTaskRequest;
import com.vhaalz.task_manager.domain.TaskResponse;
import com.vhaalz.task_manager.models.Task;
import com.vhaalz.task_manager.services.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    private List<TaskResponse> allTask(){
        return taskService.getAllTasksByUserId();
    }

    @PostMapping("/")
    private ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(request));
    }

}
