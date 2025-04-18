package com.vhaalz.task_manager.controllers;

import com.vhaalz.task_manager.dto.CreateTaskRequest;
import com.vhaalz.task_manager.dto.AllTaskResponse;
import com.vhaalz.task_manager.dto.UpdateTaskResponse;
import com.vhaalz.task_manager.services.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    private List<AllTaskResponse> allTask(){
        return taskService.getAllTasksByUserId();
    }

    @PostMapping("/")
    private ResponseEntity<UUID> createTask(@Valid @RequestBody CreateTaskRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(request));
    }

    @PutMapping("/{id}")
    private ResponseEntity<UpdateTaskResponse> updateTask(@PathVariable UUID id, @RequestBody CreateTaskRequest request){
        return ResponseEntity.ok(taskService.updateTask(id, request));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteTask(@PathVariable UUID id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
