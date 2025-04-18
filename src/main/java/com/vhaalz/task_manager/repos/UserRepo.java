package com.vhaalz.task_manager.repos;

import com.vhaalz.task_manager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
