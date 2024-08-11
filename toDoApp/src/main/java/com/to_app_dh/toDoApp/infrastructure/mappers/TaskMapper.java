package com.to_app_dh.toDoApp.infrastructure.mappers;

import com.to_app_dh.toDoApp.domain.models.Task;
import com.to_app_dh.toDoApp.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper implements BaseMapper<TaskEntity, Task>{
    private final TaskStatusMapper statusMapper;

    public TaskMapper(TaskStatusMapper statusMapper) {
        this.statusMapper = statusMapper;
    }

    @Override
    public TaskEntity toEntity(Task task) {
        TaskEntity entity = new TaskEntity();
        entity.setId(task.getId());
        entity.setTitle(task.getTitle());
        entity.setDescription(task.getDescription());
        entity.setStatus(statusMapper.toEntity(task.getStatus()));
        entity.setCreationDate(task.getCreationDate());
        return entity;
    }

    @Override
    public Task toModel(TaskEntity taskEntity) {
        Task model = new Task();
        model.setId(taskEntity.getId());
        model.setTitle(taskEntity.getTitle());
        model.setDescription(taskEntity.getDescription());
        model.setStatus(statusMapper.toModel(taskEntity.getStatus()));
        model.setCreationDate(taskEntity.getCreationDate());
        return model;
    }
}
