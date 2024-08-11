package com.to_app_dh.toDoApp.infrastructure.mappers;

import com.to_app_dh.toDoApp.domain.models.TaskStatus;
import com.to_app_dh.toDoApp.infrastructure.entities.TaskStatusEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskStatusMapper implements BaseMapper<TaskStatusEntity, TaskStatus>{
    @Override
    public TaskStatusEntity toEntity(TaskStatus model) {
        TaskStatusEntity entity = new TaskStatusEntity();
        entity.setId(model.getIdTaskStatus());
        entity.setName(model.getName());
        entity.setOrder(model.getOrder());
        return entity;
    }

    @Override
    public TaskStatus toModel(TaskStatusEntity taskStatusEntity) {
        TaskStatus model = new TaskStatus();
        model.setIdTaskStatus(taskStatusEntity.getId());
        model.setName(taskStatusEntity.getName());
        model.setOrder(taskStatusEntity.getOrder());
        return model;
    }
}
