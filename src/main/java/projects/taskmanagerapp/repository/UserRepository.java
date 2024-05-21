package projects.taskmanagerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.taskmanagerapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
