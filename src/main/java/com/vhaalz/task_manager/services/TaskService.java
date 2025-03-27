package com.vhaalz.task_manager.services;

import com.vhaalz.task_manager.config.MyUserDetailsService;
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
    public Task createTask(Task request) {

        User currentUser = myUserDetailsService.getCurrentUser();

        Task req = new Task();

        req.setTitle(request.getTitle());
        req.setDescription(request.getDescription());
        req.setStatus(TaskStatus.PENDING);
        req.setCreatedAt(LocalDateTime.now());
        req.setAssignedTo(currentUser);

       return taskRepo.save(req);
    }
}
