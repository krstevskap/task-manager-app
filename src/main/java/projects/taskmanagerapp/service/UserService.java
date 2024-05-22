package projects.taskmanagerapp.service;

import projects.taskmanagerapp.model.Task;
import projects.taskmanagerapp.model.User;
import projects.taskmanagerapp.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User findUserById(Long id);

    User findUserByEmail(String email);

    User findUserByUsername(String username);

    User createUser(UserDto userDTO);

    User createUser(String username, String name, String lastName, String email, String password);

    List<Task> findTasksByUser(Long userId);
}
