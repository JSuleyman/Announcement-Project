package com.example.announcementproject.service;

import com.example.announcementproject.repository.CityRepository;
import com.example.announcementproject.service.impl.CityServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CityServiceTest {
    @Mock
    private CityRepository cityRepository;

    private CityServiceImpl cityService;

    @BeforeEach
    void setUp(){
        cityService = new CityServiceImpl(cityRepository);
    }

    @Test
    void canGetAllCities(){
        //when
        cityService.getAll();
        //then
        verify(cityRepository).findAll();
    }
}
