package com.vhaalz.task_manager.domain;

import com.vhaalz.task_manager.models.Task;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Valid
public record RegisterRequest(

        Long id,

        @NotNull(message = "username is required")
        String username,

        @NotNull(message = "password is required")
        String password,

        @NotNull(message = "email is required")
        @Email(message = "enter a valid email address")
        String email,

        List<Task> task
) {
}
