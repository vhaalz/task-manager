package com.vhaalz.task_manager.repos;
import com.vhaalz.task_manager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {

    @Query("SELECT new com.example.dto.TaskSummaryDTO(t.id, t.title, " +
            "substring(t.description, 1, 100)) FROM Task t WHERE t.user.id = :userId")
    List<Task> findByUserId(Long userId);
}
