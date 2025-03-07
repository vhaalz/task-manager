package com.vhaalz.task_manager.repos;

import com.vhaalz.task_manager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<User, Long> {
}
