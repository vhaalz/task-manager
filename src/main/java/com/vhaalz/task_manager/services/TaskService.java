package com.vhaalz.task_manager.services;

import com.vhaalz.task_manager.config.MyUserDetailsService;
import com.vhaalz.task_manager.domain.CreateTaskRequest;
import com.vhaalz.task_manager.domain.TaskResponse;
import com.vhaalz.task_manager.domain.TaskStatus;
import com.vhaalz.task_manager.models.Task;
import com.vhaalz.task_manager.models.User;
import com.vhaalz.task_manager.repos.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final MyUserDetailsService myUserDetailsService;

    private final TaskRepo taskRepo;
    public Task createTask(CreateTaskRequest request) {

        User currentUser = myUserDetailsService.getCurrentUser();

        Task req = new Task();

        req.setTitle(request.title());
        req.setDescription(request.description());
        req.setStatus(TaskStatus.PENDING);
        req.setCreatedAt(LocalDateTime.now());
//        req.setAssignedTo(currentUser);
        req.setUserId(currentUser.getId());

       return taskRepo.save(req);
    }
}
