package com.example.carproject.daos.inter;

import com.example.carproject.enums.*;
import com.example.carproject.models.Announcement;

import java.util.List;

public interface AnnounceDAO {
    void createAnnouncement(Announcement c, Integer userId);
    List<Announcement> getSearch(String brandName, String modelName, String cityName, BanType banType, Integer mileage, MileageType mileageType, String color, Double price, Currency currency, OwnersNumber ownersNumber, FuelType fuelType, Transmitter transmitter, Gearbox gearbox, Integer carYear, Integer engineVolume, MarketAddresses marketAddresses, Repair repair, SeatsNumber seatsNumber, VendorType vendorType, SalesType salesType);
}
