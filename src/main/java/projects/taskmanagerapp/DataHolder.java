package projects.taskmanagerapp;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import projects.taskmanagerapp.model.Task;
import projects.taskmanagerapp.model.enums.Category;
import projects.taskmanagerapp.model.enums.Priority;
import projects.taskmanagerapp.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DataHolder {
    private final TaskRepository taskRepository;

    public DataHolder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostConstruct
    public void init() {
        List<Category> categories = Arrays.stream(Category.values()).toList();
        List<Priority> priorities = Arrays.stream(Priority.values()).toList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Category category = categories.get(random.nextInt(categories.size()));
            Priority priority = priorities.get(random.nextInt(priorities.size()));
            taskRepository.save(new Task("title" + i, LocalDateTime.now().plusMinutes(i), false, category, priority));
        }
    }
}
