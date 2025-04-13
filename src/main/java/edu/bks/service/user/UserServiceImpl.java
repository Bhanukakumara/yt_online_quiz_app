package edu.bks.service.user;

import edu.bks.entity.User;
import edu.bks.enums.UserRole;
import edu.bks.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void createAdminUser(){
        if (userRepository.findByRole(UserRole.ADMIN) == null){
            User user = new User();
            user.setName("Admin");
            user.setEmail("admin@gmail.com");
            user.setRole(UserRole.ADMIN);
            user.setPassword("admin");
            userRepository.save(user);
        }
    }
    public Boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email) != null;
    }
    public User createUser(User user){
        user.setRole(UserRole.USER);

        return userRepository.save(user);
    }
}
