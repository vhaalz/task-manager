package com.vhaalz.task_manager.services;

import com.vhaalz.task_manager.config.MyUserDetailsService;
import com.vhaalz.task_manager.domain.CreateTaskRequest;
import com.vhaalz.task_manager.domain.Mapper;
import com.vhaalz.task_manager.domain.TaskResponse;
import com.vhaalz.task_manager.domain.TaskStatus;
import com.vhaalz.task_manager.models.Task;
import com.vhaalz.task_manager.models.User;
import com.vhaalz.task_manager.repos.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final MyUserDetailsService myUserDetailsService;
    private final Mapper mapper;
    private final TaskRepo taskRepo;

    public TaskResponse createTask(CreateTaskRequest request) {

        User currentUser = myUserDetailsService.getCurrentUser();

        Task req = new Task();

        req.setTitle(request.title());
        req.setDescription(request.description());
        req.setStatus(TaskStatus.PENDING);
        req.setCreatedAt(LocalDateTime.now());
        req.setUserId(currentUser.getId());

       var createdTask = taskRepo.save(req);

       return mapper.fromTask(createdTask);
    }

    public List<TaskResponse> getAllTasksByUserId() {

        User currentUser = myUserDetailsService.getCurrentUser();
        var tasks = taskRepo.findByUserId(currentUser.getId());

        return tasks.stream()
                .map(mapper::fromTask)
                .collect(Collectors.toList());
    }
}
