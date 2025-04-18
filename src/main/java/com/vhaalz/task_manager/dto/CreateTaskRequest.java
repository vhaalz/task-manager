package com.vhaalz.task_manager.dto;

import com.vhaalz.task_manager.domain.TaskStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Valid
public record CreateTaskRequest(

        @NotNull(message = "Title is required")
        String title,

        String description

) {
}
