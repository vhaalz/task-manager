package com.vhaalz.task_manager.dto;

import com.vhaalz.task_manager.domain.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record AllTaskResponse(

        UUID id,

        String title,

        String description,

        TaskStatus status,

        LocalDateTime createdAt
) {
}
