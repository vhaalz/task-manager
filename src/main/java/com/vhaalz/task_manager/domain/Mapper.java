package com.vhaalz.task_manager.domain;

import com.vhaalz.task_manager.models.Task;
import com.vhaalz.task_manager.models.User;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public User toUser(RegisterRequest request) {
        return User.builder()
                .username(request.username())
                .password(request.password())
                .email(request.email())
                .build();
    }

    public TaskResponse fromTask(Task task){
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getUserId(),
                task.getDueDate(),
                task.getCreatedAt()
        );
    }
}
