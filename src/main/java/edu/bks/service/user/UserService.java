package edu.bks.service.user;

import edu.bks.entity.User;

public interface UserService {
    User createUser(User user);
    Boolean hasUserWithEmail(String email);
}
