package projects.taskmanagerapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import projects.taskmanagerapp.model.enums.Category;
import projects.taskmanagerapp.model.enums.Priority;
import projects.taskmanagerapp.model.enums.Status;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String title;
    private LocalDateTime dueDate;
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Task(String title, LocalDateTime dueDate, boolean completed, Category category, Priority priority) {
        this.title = title;
        this.dueDate = dueDate;
        this.completed = completed;
        this.user = null;
        this.category = category;
        this.priority = priority;
        this.status = Status.PENDING;
    }
}
