package com.example.carproject.services.inter;

import com.example.carproject.models.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    List<City> getAll();

    Optional<City> getCityById(Integer id);

    void addCity(City city);

    void updateCity(Integer id, City city);

}
