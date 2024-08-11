package com.to_app_dh.toDoApp.domain.ports.out;

import com.to_app_dh.toDoApp.domain.models.TaskStatus;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TaskStatusRepositoryPort {
    List<TaskStatus> findAll();
}
