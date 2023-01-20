package com.example.announcementproject.controller;

import com.example.announcementproject.model.City;
import com.example.announcementproject.service.inter.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        List<City> cities = cityService.getAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<City> getById(@PathVariable("id") Integer cityId) {
        City getCity = cityService.getCityById(cityId);
        return ResponseEntity.ok(getCity);
    }

    @PostMapping
    public void create(@RequestBody City city) {
        cityService.add(city);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer cityId, @RequestBody City city) {
        cityService.update(cityId, city);
    }

}
