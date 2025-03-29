package com.vhaalz.task_manager.domain;

import java.time.LocalDateTime;

public record UpdateTaskResponse(

        Long id,

        String title, // Title of the task

        String description,

        TaskStatus status,

        LocalDateTime dueDate,

        LocalDateTime createdAt
) {
}
