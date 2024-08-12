import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { TaskService } from '../services/task.service';
import { Task } from '../models/task.model';

@Injectable({
  providedIn: 'root'
})
export class TaskFacade {
  private tasksSubject = new BehaviorSubject<Task[]>([]);
  tasks$ = this.tasksSubject.asObservable();

  constructor(private taskService: TaskService) {
    this.loadTasks();
  }

  loadTasks(): void {
    this.taskService.getTasks().subscribe(
      tasks => this.tasksSubject.next(tasks)
    );
  }

  createTask(task: Task): void {
    this.taskService.createTask(task).subscribe(
      newTask => {
        const currentTasks = this.tasksSubject.value;
        this.tasksSubject.next([...currentTasks, newTask]);
      }
    );
  }

  updateTask(task: Task): void {
    this.taskService.updateTask(task).subscribe(
      updatedTask => {
        const currentTasks = this.tasksSubject.value;
        const index = currentTasks.findIndex(t => t.id === updatedTask.id);
        if (index !== -1) {
          currentTasks[index] = updatedTask;
          this.tasksSubject.next([...currentTasks]);
        }
      }
    );
  }

  deleteTask(id: number): void {
    this.taskService.deleteTask(id).subscribe(
      () => {
        const currentTasks = this.tasksSubject.value;
        this.tasksSubject.next(currentTasks.filter(task => task.id !== id));
      }
    );
  }
}