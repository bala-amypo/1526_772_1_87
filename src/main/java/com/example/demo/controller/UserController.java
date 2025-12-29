package com.example.demo.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @PreAuthorize("permitAll()") 
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User user = new User(null, request.getName(), request.getEmail(), 
                           request.getPassword(), "USER", null);
        User created = userService.registerUser(user);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }
    
}
