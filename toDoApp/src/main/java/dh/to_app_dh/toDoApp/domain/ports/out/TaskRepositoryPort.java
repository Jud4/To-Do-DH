package dh.to_app_dh.toDoApp.domain.ports.out;

import dh.to_app_dh.toDoApp.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> updateTask(Task updatedTask);
    List<Task> findAll();
    void deleteById(Long id);
}
