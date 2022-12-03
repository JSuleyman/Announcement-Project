package com.example.announcementproject.dto;

import com.example.announcementproject.models.City;

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
