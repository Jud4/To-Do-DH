package dh.to_app_dh.toDoApp.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;

    public Task(Long id, String title, String description, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }
}
