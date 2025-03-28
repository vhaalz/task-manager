package com.vhaalz.task_manager.domain;

import java.time.LocalDateTime;

public record AllTaskResponse(

        Long id,

        String title,

        String description,

        TaskStatus status,

        LocalDateTime createdAt
) {
}
