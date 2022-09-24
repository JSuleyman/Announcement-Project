package com.example.carproject.dto;

import com.example.carproject.models.City;

public class CityDTO {

    Integer id;
    String city;

    public CityDTO(City city) {
        this.id = city.getId();
        this.city = city.getCityName();
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
}
