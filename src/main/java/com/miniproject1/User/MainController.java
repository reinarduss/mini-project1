package com.miniproject1.User;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/user")
    public Iterable<User> index() {
        return userRepo.findAll();
    }

    @GetMapping("/login/{username}")
    public ResponseEntity<String> getUserName(@PathVariable("username") String username) {
        return ResponseEntity.of(userRepo.findById(username).map(User::getUsername));
    }
    

}
