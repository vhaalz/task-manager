package com.vhaalz.task_manager.repos;

import com.vhaalz.task_manager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
