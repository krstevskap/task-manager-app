package projects.taskmanagerapp.service;

import projects.taskmanagerapp.model.Task;
import projects.taskmanagerapp.model.enums.Category;
import projects.taskmanagerapp.model.enums.Priority;
import projects.taskmanagerapp.model.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    Task findTaskById(Long taskId);

    List<Task> findAllTasks();

    Task saveTask(String title, LocalDateTime dueDate, boolean completed, Long userId, Category category, Priority priority);

    Task updateTask(Long taskId, String title, LocalDateTime dueDate, boolean completed, Long userId, Category category, Priority priority, Status status);

    void deleteTaskById(Long taskId);

    Task addTaskToUser(Long userId, Long taskId);

}
