package projects.taskmanagerapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projects.taskmanagerapp.model.enums.Category;
import projects.taskmanagerapp.model.enums.Priority;
import projects.taskmanagerapp.model.enums.Status;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private LocalDateTime dueDate;
    private boolean completed;
    private Long userId;
    private Category category;
    private Priority priority;
    private Status status;
}
