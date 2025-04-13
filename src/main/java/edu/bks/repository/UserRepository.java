package edu.bks.repository;

import edu.bks.entity.User;
import edu.bks.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByRole(UserRole role);
    User findFirstByEmail(String email);
}
