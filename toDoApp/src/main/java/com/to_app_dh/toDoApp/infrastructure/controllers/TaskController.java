package com.to_app_dh.toDoApp.infrastructure.controllers;

import com.to_app_dh.toDoApp.application.services.TaskService;
import com.to_app_dh.toDoApp.domain.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody final Task task){
        Task createdTask = service.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }
    @GetMapping
    public ResponseEntity<List<Task>> listTasks(){
        return ResponseEntity.ok(service.getAllTasks());
    }
    @GetMapping("/progress")
    public ResponseEntity<List<Task>> listCompletedTask(@RequestParam(name = "completed") final boolean completed){
        return ResponseEntity.ok(service.getCompletedTasks(completed));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable final Long id,@RequestBody final Task updatedTask){
        if(!id.equals(updatedTask.getId())){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return service.updateTask(updatedTask)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable final Long id){
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
