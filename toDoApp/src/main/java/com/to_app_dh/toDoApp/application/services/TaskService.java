package com.to_app_dh.toDoApp.application.services;

import com.to_app_dh.toDoApp.domain.models.Task;
import com.to_app_dh.toDoApp.domain.ports.in.CreateTaskUseCase;
import com.to_app_dh.toDoApp.domain.ports.in.DeleteTaskUseCase;
import com.to_app_dh.toDoApp.domain.ports.in.RetrieveTaskUseCase;
import com.to_app_dh.toDoApp.domain.ports.in.UpdateTaskUseCase;

import java.util.List;
import java.util.Optional;

public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase, DeleteTaskUseCase {
    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;

    public TaskService(CreateTaskUseCase createTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase,
                       UpdateTaskUseCase updateTaskUseCase, DeleteTaskUseCase deleteTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public List<Task> getCompletedTasks(boolean completed) {
        return retrieveTaskUseCase.getCompletedTasks(completed);
    }

    @Override
    public Optional<Task> updateTask(Task updatedTask) {
        return updateTaskUseCase.updateTask(updatedTask);
    }
}
