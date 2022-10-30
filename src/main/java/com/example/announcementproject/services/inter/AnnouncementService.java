package com.example.announcementproject.services.inter;

import com.example.announcementproject.enums.*;
import com.example.announcementproject.models.Announcement;

import java.util.List;
import java.util.Optional;

public interface AnnouncementService {

    List<Announcement> getAll();

    Optional<Announcement> getById(Integer id);

    List<Announcement> getSearch(String brandName, String modelName, String cityName, BanType banType, Integer mileage, MileageType mileageType, String color, Double minPrice, Double maxPrice, Currency currency, OwnersNumber ownersNumber, FuelType fuelType, Transmitter transmitter, Gearbox gearbox, Integer minYear, Integer maxYear, Double minEngineVolume, Double maxEngineVolume, Integer minEnginePower, Integer maxEnginePower, MarketAddresses marketAddresses, Repair repair, SeatsNumber seatsNumber, VendorType vendorType, SalesType salesType);

    void createAnnouncement(Announcement createAnnounce, Integer userId);

    void updateAnnouncement(Integer id, Announcement updateAnnouncement, String userName);

    void deleteById(Integer id, String userName);
}