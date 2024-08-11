package com.to_app_dh.toDoApp.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "TASKSTATUS")
@Getter
@Setter
public class TaskStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    private String name;
    @Column(name = "priority")
    private Short order;
    private boolean completed;

    @OneToMany(mappedBy = "status",fetch = FetchType.EAGER)
    private List<TaskEntity> tasks;

    public TaskStatusEntity(Short id, String name, Short order, boolean completed, List<TaskEntity> tasks) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.completed = completed;
        this.tasks = tasks;
    }

    public TaskStatusEntity() {
    }
}
