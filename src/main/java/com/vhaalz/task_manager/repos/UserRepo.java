package com.vhaalz.task_manager.repos;

import com.vhaalz.task_manager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
