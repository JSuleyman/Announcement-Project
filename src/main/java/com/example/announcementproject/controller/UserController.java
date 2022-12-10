package com.example.announcementproject.controller;

import com.example.announcementproject.model.User;
import com.example.announcementproject.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Integer userId) {
        User getUser = userService.getUserById(userId);
        return ResponseEntity.ok(getUser);
    }

    @PostMapping
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer userId, @RequestBody User user) {
        userService.update(userId, user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer userId) {
        userService.deleteById(userId);
    }
}
