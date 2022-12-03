package com.example.announcementproject.controllers;

import com.example.announcementproject.dto.UserDTO;
import com.example.announcementproject.models.User;
import com.example.announcementproject.services.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.getAll();
        List<UserDTO> list = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = new UserDTO(user);
            list.add(userDTO);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") Integer userId) {
        User user = userService.getUserById(userId);
        UserDTO userDTO = new UserDTO(user);

        return ResponseEntity.ok(userDTO);
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
