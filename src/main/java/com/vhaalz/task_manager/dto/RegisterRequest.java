package com.vhaalz.task_manager.dto;

import com.vhaalz.task_manager.models.Task;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record RegisterRequest(

        @NotNull(message = "email is required")
        @Email(message = "enter a valid email address")
        String email,

        @NotNull(message = "password is required")
        String password,

        List<Task> task
) {
}
