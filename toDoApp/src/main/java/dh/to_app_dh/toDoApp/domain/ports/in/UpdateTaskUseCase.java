package dh.to_app_dh.toDoApp.domain.ports.in;

import dh.to_app_dh.toDoApp.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task updatedTask);
}
