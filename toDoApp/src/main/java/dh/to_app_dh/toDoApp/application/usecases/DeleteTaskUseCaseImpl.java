package dh.to_app_dh.toDoApp.application.usecases;

import dh.to_app_dh.toDoApp.domain.ports.in.DeleteTaskUseCase;
import dh.to_app_dh.toDoApp.domain.ports.out.TaskRepositoryPort;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepositoryPort.deleteById(id);
    }
}
