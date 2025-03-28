package com.vhaalz.task_manager.domain;

import com.vhaalz.task_manager.models.Task;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TaskResponse(

        Long id,

        String title,

        String description,

        TaskStatus status,

        Long userId,

        LocalDateTime dueDate,

        LocalDateTime createdAt
) {
}
