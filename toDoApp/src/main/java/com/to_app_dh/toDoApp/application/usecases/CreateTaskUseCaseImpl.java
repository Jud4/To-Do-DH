package com.to_app_dh.toDoApp.application.usecases;

import com.to_app_dh.toDoApp.domain.models.Task;
import com.to_app_dh.toDoApp.domain.ports.in.CreateTaskUseCase;
import com.to_app_dh.toDoApp.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
