import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TaskFacade } from '../../facades/task.facade';
import { Task } from '../../models/task.model';
import { TaskStatus } from '../../models/task-status.model';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent implements OnInit {
  taskForm: FormGroup;
  statuses: TaskStatus[] = [
    { idTaskStatus: 1, name: 'To Do', order: 1, completed: false },
    { idTaskStatus: 2, name: 'In Progress', order: 2, completed: false },
    { idTaskStatus: 3, name: 'Done', order: 3, completed: true }
  ];

  constructor(private fb: FormBuilder, private taskFacade: TaskFacade) {
    this.taskForm = this.fb.group({
      title: ['', Validators.required],
      description: [''],
      status: ['', Validators.required]
    });
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.taskForm.valid) {
      const newTask: Task = this.taskForm.value;
      this.taskFacade.createTask(newTask);
      this.taskForm.reset();
    }
  }
}