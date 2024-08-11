package com.to_app_dh.toDoApp.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity(name = "TASK")
@Getter
@Setter
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private TaskStatusEntity status;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime creationDate;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String title, String description, TaskStatusEntity status, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
    }


}
