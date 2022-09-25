package com.example.announcementproject.services.impl;

import com.example.announcementproject.models.City;
import com.example.announcementproject.repositories.CityRepository;
import com.example.announcementproject.services.inter.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {


    CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> getCityById(Integer id) {
        return cityRepository.findById(id);
    }

    @Override
    public void addCity(City city) {
        List<City> cities = cityRepository.findAll();

        for (int i = 0; i < cities.size(); i++) {
            if (city.getCityName().equalsIgnoreCase(cities.get(i).getCityName())){
                return;
            }
        }
        cityRepository.save(city);
    }

    @Override
    public void updateCity(Integer id, City city) {
        Optional<City> city1 = cityRepository.findById(id);

        City city2 = city1.get();
        city2.setCityName(city.getCityName());

        cityRepository.save(city2);
    }
}
