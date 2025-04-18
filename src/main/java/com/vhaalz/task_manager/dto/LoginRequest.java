package com.vhaalz.task_manager.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Valid
public record LoginRequest(
        @NotNull(message = "email is required")
        @Email(message = "enter a valid email")
        String email,

        @NotNull(message = "password is required")
        String password
) {
}
