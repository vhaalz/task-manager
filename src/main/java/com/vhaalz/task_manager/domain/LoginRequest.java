package com.vhaalz.task_manager.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record LoginRequest(
        @NotNull(message = "username is required")
        String username,

        @NotNull(message = "password is required")
        String password
) {
}
