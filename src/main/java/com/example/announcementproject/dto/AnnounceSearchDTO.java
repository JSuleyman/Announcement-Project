package com.example.announcementproject.dto;

import com.example.announcementproject.models.Announcement;

public class AnnounceSearchDTO {
    Integer id;

    String phoneNumber;
    String cityName;
    String brandName;
    String modelName;
    String banType;
    Integer mileage;
    String mileageType;
    String color;
    Double price;
    String currency;
    String ownersNumber;
    String fuelType;
    String transmitter;
    String gearbox;
    Integer carYear;
    Double engineVolume;
    Integer enginePower;
    String marketAddresses;
    String repair;
    String seatsNumber;
    String vendorType;
    String salesType;
    String vehicleEquip;

    public AnnounceSearchDTO(Announcement c) {
        this.id = c.getId();
        this.phoneNumber = c.getUserId().getPhoneNumber();
        this.cityName = c.getUserId().getCityId().getCityName();
        this.brandName = c.getBrandId().getBrandName();
        this.modelName = c.getModelId().getModelName();
        this.banType = c.getBanType().getValue();
        this.mileage = c.getMileage();
        this.mileageType = c.getMileageType().getValue();
        this.color = c.getColor();
        this.price = c.getPrice();
        this.currency = c.getCurrency().name();
        this.ownersNumber = c.getOwnersNumber().getValue();
        this.fuelType = c.getFuelType().getValue();
        this.transmitter = c.getTransmitter().getValue();
        this.gearbox = c.getGearbox().getValue();
        this.carYear = c.getCarYear();
        this.engineVolume = c.getEngineVolume();
        this.enginePower = c.getEnginePower();
        this.marketAddresses = c.getMarketAddresses().getValue();
        this.repair = c.getRepair().getValue();
        this.seatsNumber = c.getSeatsNumber().getValue();
        this.vendorType = c.getVendorType().getValue();
        this.salesType = c.getSalesType().getValue();
        this.vehicleEquip = c.getVehicleEquip();
    }

    public Integer getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public String getBanType() {
        return banType;
    }

    public Integer getMileage() {
        return mileage;
    }

    public String getMileageType() {
        return mileageType;
    }

    public String getColor() {
        return color;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getOwnersNumber() {
        return ownersNumber;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTransmitter() {
        return transmitter;
    }

    public String getGearbox() {
        return gearbox;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public String getMarketAddresses() {
        return marketAddresses;
    }

    public String getRepair() {
        return repair;
    }

    public String getSeatsNumber() {
        return seatsNumber;
    }

    public String getVendorType() {
        return vendorType;
    }

    public String getSalesType() {
        return salesType;
    }

    public String getVehicleEquip() {
        return vehicleEquip;
    }
}
