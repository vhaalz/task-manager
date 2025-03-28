package com.vhaalz.task_manager.domain;

import java.time.LocalDateTime;

public record AllTaskResponse(

        String title,

        String description,

        TaskStatus status,

        LocalDateTime createdAt
) {
}
