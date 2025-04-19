package com.vhaalz.task_manager.services;

import com.vhaalz.task_manager.config.MyUserDetailsService;
import com.vhaalz.task_manager.domain.*;
import com.vhaalz.task_manager.dto.AllTaskResponse;
import com.vhaalz.task_manager.dto.CreateTaskRequest;
import com.vhaalz.task_manager.dto.TaskResponse;
import com.vhaalz.task_manager.dto.UpdateTaskResponse;
import com.vhaalz.task_manager.exception.TaskNotFoundException;
import com.vhaalz.task_manager.models.Task;
import com.vhaalz.task_manager.models.User;
import com.vhaalz.task_manager.repos.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final MyUserDetailsService myUserDetailsService;
    private final Mapper mapper;
    private final TaskRepo taskRepo;

    public UUID createTask(CreateTaskRequest request) {

        User currentUser = myUserDetailsService.getCurrentUser();

        Task req = new Task();

        req.setTitle(request.title());
        req.setDescription(request.description());
        req.setStatus(TaskStatus.PENDING);
        req.setCreatedAt(LocalDateTime.now());
        req.setUser(currentUser);

       return taskRepo.save(req).getId();
    }

    public List<AllTaskResponse> getAllTasksByUserId() {

        User currentUser = myUserDetailsService.getCurrentUser();
        var tasks = taskRepo.findByUserId(currentUser.getId());

        return tasks.stream()
                .map(mapper::fromTask)
                .collect(Collectors.toList());
    }

    public UpdateTaskResponse updateTask(UUID id , CreateTaskRequest request) {

        var user = taskRepo.findById(id).orElseThrow(
                () -> new TaskNotFoundException("task not found")
        );

        return null;
    }

    public void deleteTask(UUID id) {
        taskRepo.deleteById(id);
    }

    public TaskResponse getTaskById(UUID id) {
        var task = taskRepo.findById(id).orElseThrow(
                () -> new TaskNotFoundException("task not found")
        );

        return mapper.fromSingleTask(task);
    }
}
