import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TaskFacade } from '../../facades/task.facade';
import { Task } from '../../models/task.model';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  tasks$: Observable<Task[]>;

  constructor(private taskFacade: TaskFacade) {
    this.tasks$ = this.taskFacade.tasks$;
  }

  ngOnInit(): void {
    this.taskFacade.loadTasks();
  }

  deleteTask(id: number): void {
    if (id < 0) {
      this.taskFacade.deleteTask(id);
    } else {
      console.error('Attempted to delete a task with undefined id');
    }
  }
}