package com.example.announcementproject.services.impl;

import com.example.announcementproject.daos.inter.CreateUserDAO;
import com.example.announcementproject.exceptions.UserNotFoundException;
import com.example.announcementproject.models.User;
import com.example.announcementproject.repositories.UserRepository;
import com.example.announcementproject.services.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
    private final UserRepository userRepository;

    private final CreateUserDAO createUserDAO;

    @Override
    public User getUserById(Integer userId) {
        return userRepository.getUserById(userId).stream()
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void register(User user) {
        user.setPassword(crypt.encode(user.getPassword()));
        createUserDAO.createUser(user);
    }

    @Override
    public void update(Integer userId, User user) {
        User updateUser = userRepository.getUserById(userId).stream()
                .findFirst()
                .orElseThrow(UserNotFoundException::new);

        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhoneNumber(user.getPhoneNumber());
        updateUser.setCityId(user.getCityId());

        userRepository.save(updateUser);
    }

    @Override
    public void deleteById(Integer userId) {
        User user = userRepository.getUserById(userId).stream()
                .findFirst()
                .orElseThrow(UserNotFoundException::new);

        userRepository.deleteById(user.getId());
    }
}
