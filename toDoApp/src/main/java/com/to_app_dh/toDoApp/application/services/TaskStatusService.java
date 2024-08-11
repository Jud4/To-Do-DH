package com.to_app_dh.toDoApp.application.services;

import com.to_app_dh.toDoApp.domain.models.TaskStatus;
import com.to_app_dh.toDoApp.domain.ports.in.RetrieveTaskStatusUseCase;

import java.util.List;

public class TaskStatusService implements RetrieveTaskStatusUseCase {
    private final RetrieveTaskStatusUseCase retrieveTaskStatusUseCase;

    public TaskStatusService(RetrieveTaskStatusUseCase retrieveTaskStatusUseCase) {
        this.retrieveTaskStatusUseCase = retrieveTaskStatusUseCase;
    }

    @Override
    public List<TaskStatus> listTaskStatuses() {
        return retrieveTaskStatusUseCase.listTaskStatuses();
    }
}
