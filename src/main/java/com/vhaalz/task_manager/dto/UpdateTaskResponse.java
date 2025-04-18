package com.vhaalz.task_manager.dto;

import com.vhaalz.task_manager.domain.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateTaskResponse(

        UUID id,

        String title, // Title of the task

        String description,

        TaskStatus status,

        LocalDateTime dueDate,

        LocalDateTime createdAt
) {
}
