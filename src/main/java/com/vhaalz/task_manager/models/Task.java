package com.vhaalz.task_manager.models;

import com.vhaalz.task_manager.domain.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title must be at most 255 characters")
    @Column(nullable = false)
    private String title;  // Title of the task

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

//    @Column(name = "user_id", nullable = false)
//    private UUID userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id", nullable = false)
    private User user;

    private LocalDateTime dueDate;

    private LocalDateTime createdAt;

}
