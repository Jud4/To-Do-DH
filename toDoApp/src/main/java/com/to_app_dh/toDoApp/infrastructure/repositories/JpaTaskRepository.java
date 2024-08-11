package com.to_app_dh.toDoApp.infrastructure.repositories;

import com.to_app_dh.toDoApp.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findAllByStatus_Completed(boolean complete);
}
