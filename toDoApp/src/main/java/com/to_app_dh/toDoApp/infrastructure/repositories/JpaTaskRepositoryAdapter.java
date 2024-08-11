package com.to_app_dh.toDoApp.infrastructure.repositories;

import com.to_app_dh.toDoApp.domain.models.Task;
import com.to_app_dh.toDoApp.domain.ports.out.TaskRepositoryPort;
import com.to_app_dh.toDoApp.infrastructure.entities.TaskEntity;
import com.to_app_dh.toDoApp.infrastructure.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {
    private final JpaTaskRepository jpaTaskRepository;
    private final TaskMapper taskMapper;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository, TaskMapper taskMapper) {
        this.jpaTaskRepository = jpaTaskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = taskMapper.toEntity(task);
        return taskMapper.toModel(jpaTaskRepository.save(taskEntity));
    }

    @Override
    public Optional<Task> updateTask(Task updatedTask) {
        if(jpaTaskRepository.existsById(updatedTask.getId())){
            TaskEntity taskEntity = taskMapper.toEntity(updatedTask);
            return Optional.of(taskMapper.toModel(jpaTaskRepository.save(taskEntity)));
        }
        return Optional.empty();
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll()
                .stream()
                .map(taskMapper::toModel)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaTaskRepository.deleteById(id);
    }

    @Override
    public List<Task> findCompletedTask(boolean complete) {
        return jpaTaskRepository.findAllByStatus_Completed(complete).stream()
                .map(taskMapper::toModel)
                .toList();
    }
}
