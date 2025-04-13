package edu.bks.controller;

import edu.bks.entity.User;
import edu.bks.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody User user){
        if (userService.hasUserWithEmail(user.getEmail())){
            return  new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
        }
        User createUser = userService.createUser(user);
        if (createUser == null){
            return new ResponseEntity<>("User not created, Come again later",HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(createUser, HttpStatus.OK);
    }
}
