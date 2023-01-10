package com.app.backend.controller;

import com.app.backend.model.User;
import com.app.backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepo repo;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData) {
        System.out.println(userData);
        System.out.println(userData);
        User user=repo.findByUserId(userData.getUserId());
        if(user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

}