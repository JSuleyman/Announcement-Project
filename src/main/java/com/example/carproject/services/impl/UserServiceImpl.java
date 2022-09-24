package com.example.carproject.services.impl;

import com.example.carproject.daos.inter.CreateUserDAO;
import com.example.carproject.exceptions.NotFoundUser;
import com.example.carproject.models.User;
import com.example.carproject.repositories.UserRepository;
import com.example.carproject.services.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    CreateUserDAO createUserDAO;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CreateUserDAO createUserDAO) {
        this.userRepository = userRepository;
        this.createUserDAO = createUserDAO;
    }

    @Override
    public User getUserById(Integer id) {
        if (userRepository.getUserById(id) == null) throw new NotFoundUser();
        {
            return userRepository.getUserById(id);
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void registerUser(User user) {
        createUserDAO.createUser(user);
    }

    @Override
    public void updateUser(Integer id, User user) {
        User user1 = userRepository.getUserById(id);

        if (user1 == null) throw new NotFoundUser();
        {
            user1.setName(user.getName());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            user1.setPhoneNumber(user.getPhoneNumber());
            user1.setCityId(user.getCityId());

            userRepository.save(user1);
        }
    }

    @Override
    public void deleteUserById(Integer id) {

        if (userRepository.getUserById(id) == null) throw new NotFoundUser();
        {
            userRepository.deleteById(id);
        }

    }
}
