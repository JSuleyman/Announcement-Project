package com.example.announcementproject.controllers;

import com.example.announcementproject.dto.UserDTO;
import com.example.announcementproject.models.User;
import com.example.announcementproject.services.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.getAll();
        List<UserDTO> list = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = new UserDTO(user);
            list.add(userDTO);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }
}
