package dh.to_app_dh.toDoApp.application.usecases;

import dh.to_app_dh.toDoApp.domain.models.Task;
import dh.to_app_dh.toDoApp.domain.ports.in.UpdateTaskUseCase;
import dh.to_app_dh.toDoApp.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepositoryPort.updateTask(updatedTask);
    }
}
