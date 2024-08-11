package com.to_app_dh.toDoApp.application.usecases;

import com.to_app_dh.toDoApp.domain.models.TaskStatus;
import com.to_app_dh.toDoApp.domain.ports.in.RetrieveTaskStatusUseCase;
import com.to_app_dh.toDoApp.domain.ports.out.TaskStatusRepositoryPort;

import java.util.List;

public class RetrieveTaskStatusUseCaseImpl implements RetrieveTaskStatusUseCase {
    private final TaskStatusRepositoryPort taskStatusRepositoryPort;

    public RetrieveTaskStatusUseCaseImpl(TaskStatusRepositoryPort taskStatusRepositoryPort) {
        this.taskStatusRepositoryPort = taskStatusRepositoryPort;
    }

    @Override
    public List<TaskStatus> listTaskStatuses() {
        return taskStatusRepositoryPort.findAll();
    }
}
