package com.to_app_dh.toDoApp.domain.ports.out;

import com.to_app_dh.toDoApp.domain.models.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> updateTask(Task updatedTask);
    List<Task> findAll();
    void deleteById(Long id);
    List<Task> findCompletedTask(boolean complete);
}
