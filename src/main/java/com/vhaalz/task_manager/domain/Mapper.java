package com.vhaalz.task_manager.domain;

import com.vhaalz.task_manager.models.User;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public User toUser(UserRequest request) {
        return User.builder()
                .username(request.username())
                .password(request.password())
                .email(request.email())
                .build();
    }
}
