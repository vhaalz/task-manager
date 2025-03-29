package com.vhaalz.task_manager.repos;
import com.vhaalz.task_manager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {

    List<Task> findByUserId(Long userId);
}
