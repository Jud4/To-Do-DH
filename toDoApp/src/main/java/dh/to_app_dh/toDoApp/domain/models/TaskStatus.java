package dh.to_app_dh.toDoApp.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskStatus {
    private Short idTaskStatus;
    private String name;
    private Short order;

    public TaskStatus(Short idTaskStatus, String name, Short order) {
        this.idTaskStatus = idTaskStatus;
        this.name = name;
        this.order = order;
    }
}
