package com.to_app_dh.toDoApp.infrastructure.config;

import com.to_app_dh.toDoApp.application.services.TaskService;
import com.to_app_dh.toDoApp.application.services.TaskStatusService;
import com.to_app_dh.toDoApp.application.usecases.*;
import com.to_app_dh.toDoApp.domain.ports.out.TaskRepositoryPort;
import com.to_app_dh.toDoApp.domain.ports.out.TaskStatusRepositoryPort;
import com.to_app_dh.toDoApp.infrastructure.repositories.JpaTaskRepositoryAdapter;
import com.to_app_dh.toDoApp.infrastructure.repositories.JpaTaskStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort){
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort)
        );
    }
    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public TaskStatusService taskStatusService(TaskStatusRepositoryPort taskStatusRepositoryPort){
        return new TaskStatusService(
                new RetrieveTaskStatusUseCaseImpl(taskStatusRepositoryPort)
        );
    }
    @Bean
    public TaskStatusRepositoryPort taskStatusRepositoryPort(JpaTaskStatusRepositoryAdapter jpaTaskStatusRepositoryAdapter){
        return jpaTaskStatusRepositoryAdapter;
    }
}
