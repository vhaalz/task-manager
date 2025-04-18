package com.vhaalz.task_manager.repos;
import com.vhaalz.task_manager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepo extends JpaRepository<Task, UUID> {

    List<Task> findByUserId(UUID userId);
}
