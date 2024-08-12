import { TaskStatus } from "./task-status.model";

export interface Task {
  id?: number;
  title: string;
  description: string;
  status: TaskStatus;
  creationDate?: Date;
}

