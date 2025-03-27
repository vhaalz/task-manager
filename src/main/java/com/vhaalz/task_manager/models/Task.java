package com.vhaalz.task_manager.models;

import com.vhaalz.task_manager.domain.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title must be at most 255 characters")
    @Column(nullable = false)
    private String title;  // Title of the task

    @Size(max = 1000, message = "Description must be at most 1000 characters")
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "users", nullable = false)
    private User assignedTo;

    private LocalDateTime dueDate;

    private LocalDateTime createdAt;

}
