package projects.taskmanagerapp.service.implementation;

import org.springframework.stereotype.Service;
import projects.taskmanagerapp.model.Task;
import projects.taskmanagerapp.model.User;
import projects.taskmanagerapp.model.dto.UserDto;
import projects.taskmanagerapp.repository.UserRepository;
import projects.taskmanagerapp.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User findUserByUsername(String username) {
        return this.findUserByUsername(username);
    }

    @Override
    public User createUser(UserDto userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User createUser(String username, String name, String lastName, String email, String password) {
        User user = new User(username, name, lastName, email, password);
        return userRepository.save(user);
    }

    @Override
    public List<Task> findTasksByUser(Long userId) {
        User user = this.findUserById(userId);
        if(user == null) return new ArrayList<Task>();
        return user.getTasks();
    }
}
