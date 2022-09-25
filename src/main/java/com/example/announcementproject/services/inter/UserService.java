package com.example.announcementproject.services.inter;

import com.example.announcementproject.models.User;

import java.util.List;


public interface UserService {
    User getUserById(Integer id);

    List<User> getAll();

    void registerUser(User user);

    void updateUser(Integer id, User user);

    void deleteUserById(Integer id);


}
