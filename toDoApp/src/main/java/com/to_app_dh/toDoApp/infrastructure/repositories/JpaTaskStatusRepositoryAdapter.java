package com.to_app_dh.toDoApp.infrastructure.repositories;

import com.to_app_dh.toDoApp.domain.models.TaskStatus;
import com.to_app_dh.toDoApp.domain.ports.out.TaskStatusRepositoryPort;
import com.to_app_dh.toDoApp.infrastructure.mappers.TaskStatusMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class JpaTaskStatusRepositoryAdapter implements TaskStatusRepositoryPort {
    private final JpaTaskStatusRepository repository;
    private final TaskStatusMapper statusMapper;

    public JpaTaskStatusRepositoryAdapter(JpaTaskStatusRepository repository, TaskStatusMapper statusMapper) {
        this.repository = repository;
        this.statusMapper = statusMapper;
    }

    @Override
    public List<TaskStatus> findAll() {
        return repository.findAll()
                .stream()
                .map(statusMapper::toModel)
                .toList();
    }
}
