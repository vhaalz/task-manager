package com.vhaalz.task_manager.domain;

import com.vhaalz.task_manager.dto.AllTaskResponse;
import com.vhaalz.task_manager.dto.RegisterRequest;
import com.vhaalz.task_manager.models.Task;
import com.vhaalz.task_manager.models.User;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public User toUser(RegisterRequest request) {
        return User.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }

    public AllTaskResponse fromTask(Task task){
        return new AllTaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt()
        );
    }
}
