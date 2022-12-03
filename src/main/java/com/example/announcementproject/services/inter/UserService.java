package com.example.announcementproject.services.inter;

import com.example.announcementproject.models.User;

import java.util.List;


public interface UserService {
    User getUserById(Integer userId);

    List<User> getAll();

    void register(User user);

    void update(Integer id, User user);

    void deleteById(Integer id);


}
