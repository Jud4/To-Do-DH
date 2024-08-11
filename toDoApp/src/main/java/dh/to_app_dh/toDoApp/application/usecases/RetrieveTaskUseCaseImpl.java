package dh.to_app_dh.toDoApp.application.usecases;

import dh.to_app_dh.toDoApp.domain.models.Task;
import dh.to_app_dh.toDoApp.domain.ports.in.RetrieveTaskUseCase;
import dh.to_app_dh.toDoApp.domain.ports.out.TaskRepositoryPort;

import java.util.List;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }
}
