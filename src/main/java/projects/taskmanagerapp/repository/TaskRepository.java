package projects.taskmanagerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import projects.taskmanagerapp.model.enums.Category;
import projects.taskmanagerapp.model.enums.Priority;
import projects.taskmanagerapp.model.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);

    List<Task> findByStatus(Status status);

    List<Task> findByCategory(Category category);

    List<Task> findByPriority(Priority priority);

    List<Task> findByDueDateBefore(LocalDateTime dueDate);
}
