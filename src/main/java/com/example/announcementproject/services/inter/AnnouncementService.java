package com.example.announcementproject.services.inter;

import com.example.announcementproject.dto.AnnouncementSearchFilter;
import com.example.announcementproject.models.Announcement;

import java.util.List;

public interface AnnouncementService {

    List<Announcement> findAll();

    Announcement getById(Integer announcementId);

//    List<Announcement> getSearch(String brandName, String modelName, String cityName, BanType banType, Integer mileage, MileageType mileageType, String color, Double minPrice, Double maxPrice, Currency currency, OwnersNumber ownersNumber, FuelType fuelType, Transmitter transmitter, Gearbox gearbox, Integer minYear, Integer maxYear, Double minEngineVolume, Double maxEngineVolume, Integer minEnginePower, Integer maxEnginePower, MarketAddresses marketAddresses, Repair repair, SeatsNumber seatsNumber, VendorType vendorType, SalesType salesType);

    List<Announcement> getSearch(AnnouncementSearchFilter filter);

    void create(Announcement createAnnounce);

    void update(Integer id, Announcement updateAnnouncement, String userName);

    void deleteById(Integer announcementId, String userName);
}
