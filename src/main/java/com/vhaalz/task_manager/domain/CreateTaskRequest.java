package com.vhaalz.task_manager.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Valid
public record CreateTaskRequest(

        Long id,

        @NotNull(message = "Title is required")
        String title,

        String description,

        TaskStatus status,

        Long userId,

        LocalDateTime dueDate,

        LocalDateTime createdAt

) {
}
