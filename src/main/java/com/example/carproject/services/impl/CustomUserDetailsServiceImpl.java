package com.example.carproject.services.impl;

import com.example.carproject.exceptions.NotFoundUser;
import com.example.carproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        List<com.example.carproject.models.User> getAll = userRepository.findAll();

        for (com.example.carproject.models.User user : getAll) {
            if (userName.equals(user.getName())) {
                return new User(user.getName(), user.getPassword(), new ArrayList<>());
            }
        }
        return null;
    }
}
