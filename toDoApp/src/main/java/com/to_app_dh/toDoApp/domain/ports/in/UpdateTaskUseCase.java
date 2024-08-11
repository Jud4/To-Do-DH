package com.to_app_dh.toDoApp.domain.ports.in;

import com.to_app_dh.toDoApp.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Task updatedTask);
}
