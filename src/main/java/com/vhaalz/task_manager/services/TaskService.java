package com.vhaalz.task_manager.services;

import com.vhaalz.task_manager.models.Task;
import com.vhaalz.task_manager.repos.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;
    public Task createTask(Task request) {

        Task req = new Task();

        req.setTitle(request.getTitle());
        req.setDescription(request.getDescription());
        req.setStatus(false);
        req.setCreatedAt(LocalDateTime.now());

       return taskRepo.save(req);
    }
}
