package com.example.announcementproject.controllers;

import com.example.announcementproject.dto.CityDTO;
import com.example.announcementproject.models.City;
import com.example.announcementproject.services.inter.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityDTO>> getAll() {
        List<City> cities = cityService.getAll();
        List<CityDTO> list = new ArrayList<>();

        for (City city : cities) {
            CityDTO cityDTO = new CityDTO(city);
            list.add(cityDTO);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable("id") Integer cityId) {
        City city = cityService.getCityById(cityId);
        CityDTO cityDTO = new CityDTO(city);

        return ResponseEntity.ok(cityDTO);
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
