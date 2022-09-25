package com.example.announcementproject.daos.inter;

import com.example.announcementproject.enums.*;
import com.example.announcementproject.models.Announcement;

import java.util.List;

public interface AnnounceDAO {
    void createAnnouncement(Announcement c, Integer userId);
    List<Announcement> getSearch(String brandName, String modelName, String cityName, BanType banType, Integer mileage, MileageType mileageType, String color, Double minPrice, Double maxPrice, Currency currency, OwnersNumber ownersNumber, FuelType fuelType, Transmitter transmitter, Gearbox gearbox, Integer minYear, Integer maxYear, Double minEngineVolume, Double maxEngineVolume, Integer minEnginePower, Integer maxEnginePower, MarketAddresses marketAddresses, Repair repair, SeatsNumber seatsNumber, VendorType vendorType, SalesType salesType);
}
