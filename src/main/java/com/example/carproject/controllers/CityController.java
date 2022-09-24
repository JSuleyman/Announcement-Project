package com.example.carproject.controllers;

import com.example.carproject.dto.CityDTO;
import com.example.carproject.models.City;
import com.example.carproject.services.inter.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CityDTO>> getAll(){
        List<City> cities = cityService.getAll();
        List<CityDTO> list = new ArrayList<>();

        for (City city : cities) {
            CityDTO cityDTO = new CityDTO(city);
            list.add(cityDTO);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable Integer id) {
        City city = cityService.getCityById(id).orElseThrow();
        CityDTO cityDTO = new CityDTO(city);
        return ResponseEntity.ok(cityDTO);
    }

    @PostMapping("/addCity")
    public void addCity(@RequestBody City city){
        cityService.addCity(city);
    }

    @PutMapping("/updateCity/{id}")
    public void updateCity(@PathVariable Integer id,@RequestBody City city){
        cityService.updateCity(id, city);
    }
}
