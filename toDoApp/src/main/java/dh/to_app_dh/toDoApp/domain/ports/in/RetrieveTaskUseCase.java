package dh.to_app_dh.toDoApp.domain.ports.in;

import dh.to_app_dh.toDoApp.domain.models.Task;

import java.util.List;

public interface RetrieveTaskUseCase {
    List<Task> getAllTasks();
}
