package com.example.announcementproject.daos.impl;

import com.example.announcementproject.daos.inter.CreateUserDAO;
import com.example.announcementproject.models.City;
import com.example.announcementproject.models.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class CreateUserImplDAO implements CreateUserDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void createUser(User user) {
        entityManager.createNativeQuery("INSERT INTO users(user_name, email, user_password, phone_number, city_id) VALUES(?,?,?,?,?)")
                .setParameter(1, user.getName())
                .setParameter(2, user.getEmail())
                .setParameter(3, user.getPassword())
                .setParameter(4, user.getPhoneNumber())
                .setParameter(5, new City(user.getCityId().getId()))
                .executeUpdate();
    }
}
