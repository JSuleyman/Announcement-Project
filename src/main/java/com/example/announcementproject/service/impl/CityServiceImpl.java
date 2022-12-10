package com.example.announcementproject.service.impl;

import com.example.announcementproject.exception.CityAlreadyExist;
import com.example.announcementproject.exception.CityNotFoundException;
import com.example.announcementproject.model.City;
import com.example.announcementproject.repository.CityRepository;
import com.example.announcementproject.service.inter.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Integer cityId) {
        return cityRepository.findById(cityId).stream()
                .findFirst()
                .orElseThrow(CityNotFoundException::new);
    }

    @Override
    public void add(City city) {
        try {
            cityRepository.save(city);
        } catch (RuntimeException e) {
            throw new CityAlreadyExist();
        }
    }

    @Override
    public void update(Integer cityId, City newCity) {
        City city = cityRepository.findById(cityId).stream()
                .findFirst()
                .orElseThrow(CityNotFoundException::new);

        city.setCityName(newCity.getCityName());

        cityRepository.save(city);
    }
}
