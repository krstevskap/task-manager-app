package projects.taskmanagerapp.controller;

import org.springframework.web.bind.annotation.*;
import projects.taskmanagerapp.model.Task;
import projects.taskmanagerapp.model.dto.TaskDto;
import projects.taskmanagerapp.service.TaskService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }

    @PostMapping("/add")
    public Task createTask(@RequestBody TaskDto taskDTO) {
        return taskService.saveTask(
                taskDTO.getTitle(),
                taskDTO.getDueDate(),
                taskDTO.isCompleted(),
                taskDTO.getUserId(),
                taskDTO.getCategory(),
                taskDTO.getPriority()
        );
    }

    @PutMapping("/edit/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody TaskDto taskDTO) {
        return taskService.updateTask(
                id,
                taskDTO.getTitle(),
                taskDTO.getDueDate(),
                taskDTO.isCompleted(),
                taskDTO.getUserId(),
                taskDTO.getCategory(),
                taskDTO.getPriority(),
                taskDTO.getStatus()
        );
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

    @PostMapping("/add-to-user/{userId}/{taskId}")
    public Task addTaskToUser(@PathVariable Long userId, @PathVariable Long taskId) {
        return taskService.addTaskToUser(userId, taskId);
    }
}
