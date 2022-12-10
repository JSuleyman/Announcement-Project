package com.example.announcementproject.service.inter;

import com.example.announcementproject.model.City;

import java.util.List;

public interface CityService {
    List<City> getAll();

    City getCityById(Integer id);

    void add(City city);

    void update(Integer cityId, City newCity);

}
