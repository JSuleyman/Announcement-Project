package com.example.announcementproject.dto;

import com.example.announcementproject.models.User;

public class UserDTO {
    Integer id;
   private String name;
   private String email;
   private String phoneNumber;

   private String password;



    private String cityName;
    public UserDTO(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.email = u.getEmail();
        this.phoneNumber = u.getPhoneNumber();
        this.password = u.getPassword();
        this.cityName = u.getCityId().getCityName();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
