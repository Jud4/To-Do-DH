package com.to_app_dh.toDoApp.infrastructure.repositories;

import com.to_app_dh.toDoApp.infrastructure.entities.TaskStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface JpaTaskStatusRepository extends JpaRepository<TaskStatusEntity,Short> {
}
