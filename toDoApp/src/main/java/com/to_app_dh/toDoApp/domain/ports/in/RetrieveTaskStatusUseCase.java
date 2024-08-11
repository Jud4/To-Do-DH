package com.to_app_dh.toDoApp.domain.ports.in;

import com.to_app_dh.toDoApp.domain.models.TaskStatus;

import java.util.List;

public interface RetrieveTaskStatusUseCase {
    List<TaskStatus> listTaskStatuses();
}
