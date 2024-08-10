package dh.to_app_dh.toDoApp.domain.ports.in;

import dh.to_app_dh.toDoApp.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
