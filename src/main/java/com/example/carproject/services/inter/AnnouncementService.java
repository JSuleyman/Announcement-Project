package com.example.carproject.services.inter;

import com.example.carproject.enums.*;
import com.example.carproject.models.Announcement;

import java.util.List;
import java.util.Optional;

public interface AnnouncementService {

    List<Announcement> getAll();

    Optional<Announcement> getById(Integer id);

    List<Announcement> getSearch(String brandName, String modelName, String cityName, BanType banType, Integer mileage, MileageType mileageType, String color, Double price, Currency currency, OwnersNumber ownersNumber, FuelType fuelType, Transmitter transmitter, Gearbox gearbox, Integer carYear, Integer engineVolume, MarketAddresses marketAddresses, Repair repair, SeatsNumber seatsNumber, VendorType vendorType, SalesType salesType);

    void createAnnouncement(Announcement createAnnounce, Integer userId);

    void updateAnnouncement(Integer id, Announcement updateAnnouncement, String userName);

    void deleteById(Integer id, String userName);
}
