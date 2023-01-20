package com.example.announcementproject.dto;

import com.example.announcementproject.enums.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementSearchFilter {
    String brandName;
    String modelName;
    String cityName;
    BanType banType;
    Integer mileage;
    MileageType mileageType;
    String color;
    Double minPrice;
    Double maxPrice;
    Currency currency;
    OwnersNumber ownersNumber;
    FuelType fuelType;
    Transmitter transmitter;
    Gearbox gearbox;
    Integer minYear;
    Integer maxYear;
    Double minEngineVolume;
    Double maxEngineVolume;
    Integer minEnginePower;
    Integer maxEnginePower;
    MarketAddresses marketAddresses;
    Repair repair;
    SeatsNumber seatsNumber;
    VendorType vendorType;
    SalesType salesTyp;

}
