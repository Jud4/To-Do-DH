package com.to_app_dh.toDoApp.application.usecases;

import com.to_app_dh.toDoApp.domain.models.Task;
import com.to_app_dh.toDoApp.domain.ports.in.UpdateTaskUseCase;
import com.to_app_dh.toDoApp.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Task updatedTask) {
        return taskRepositoryPort.updateTask(updatedTask);
    }
}
