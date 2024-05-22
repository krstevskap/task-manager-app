package projects.taskmanagerapp.service.implementation;

import org.springframework.stereotype.Service;
import projects.taskmanagerapp.model.Task;
import projects.taskmanagerapp.model.User;
import projects.taskmanagerapp.model.enums.Category;
import projects.taskmanagerapp.model.enums.Priority;
import projects.taskmanagerapp.model.enums.Status;
import projects.taskmanagerapp.repository.TaskRepository;
import projects.taskmanagerapp.repository.UserRepository;
import projects.taskmanagerapp.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImplementation(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Task findTaskById(Long taskId) {
        return this.taskRepository.findById(taskId).orElse(null);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(String title, LocalDateTime dueDate, boolean completed, Long userId, Category category, Priority priority) {
        Task task = new Task(title, dueDate, completed, category, priority);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, String title, LocalDateTime dueDate, boolean completed, Long userId, Category category, Priority priority, Status status) {
        Task task = this.findTaskById(taskId);
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) return null;
        task.setTitle(title);
        task.setDueDate(dueDate);
        task.setCompleted(completed);
        task.setUser(user);
        task.setCategory(category);
        task.setPriority(priority);
        task.setStatus(status);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long taskId) {
        this.taskRepository.deleteById(taskId);
    }

    @Override
    public Task addTaskToUser(Long userId, Long taskId) {
        User user = userRepository.findById(userId).orElse(null);
        Task task = this.findTaskById(taskId);
        if(user==null || task==null) return null;
        task.setUser(user);
        return taskRepository.save(task);
    }
}
