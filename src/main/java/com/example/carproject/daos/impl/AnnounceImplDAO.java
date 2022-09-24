package com.example.carproject.daos.impl;

import com.example.carproject.daos.inter.AnnounceDAO;
import com.example.carproject.enums.*;
import com.example.carproject.models.CarBrand;
import com.example.carproject.models.CarModel;
import com.example.carproject.models.Announcement;
import com.example.carproject.models.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class AnnounceImplDAO implements AnnounceDAO {


    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void createAnnouncement(Announcement c, Integer userId) {
        entityManager.createNativeQuery("INSERT INTO announcements(brand_id, model_id, ban_type," +
                        "mileage,mileage_type, color, price,currency, " +
                        "owners_number, fuel_type,transmitter, gearbox,car_year, " +
                        "engine_volume,engine_power ,market_address,repair, " +
                        "seats_number,vendor_type,sales_type, description, vehicle_equip,user_id)" +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")
                .setParameter(1, new CarBrand(c.getBrandId().getId()))
                .setParameter(2, new CarModel(c.getModelId().getId()))
                .setParameter(3, c.getBanType().name())
                .setParameter(4, c.getMileage())
                .setParameter(5, c.getMileageType().name())
                .setParameter(6, c.getColor())
                .setParameter(7, c.getPrice())
                .setParameter(8, c.getCurrency().name())
                .setParameter(9, c.getOwnersNumber().name())
                .setParameter(10, c.getFuelType().name())
                .setParameter(11, c.getTransmitter().name())
                .setParameter(12, c.getGearbox().name())
                .setParameter(13, c.getCarYear())
                .setParameter(14, c.getEngineVolume())
                .setParameter(15, c.getEnginePower())
                .setParameter(16, c.getMarketAddresses().name())
                .setParameter(17, c.getRepair().name())
                .setParameter(18, c.getSeatsNumber().name())
                .setParameter(19, c.getVendorType().name())
                .setParameter(20, c.getSalesType().name())
                .setParameter(21, c.getDescription())
                .setParameter(22, c.getVehicleEquip())
                .setParameter(23, new User(c.getUserId().getId()))
                .executeUpdate();
    }
    @Override
    public List<Announcement> getSearch(String brandName, String modelName, String cityName, BanType banType, Integer mileage, MileageType mileageType, String color, Double price, Currency currency, OwnersNumber ownersNumber, FuelType fuelType, Transmitter transmitter, Gearbox gearbox, Integer carYear, Integer engineVolume, MarketAddresses marketAddresses, Repair repair, SeatsNumber seatsNumber, VendorType vendorType, SalesType salesType) {
        String sql = "SELECT a from Announcement a where 1=1";

        if (brandName != null) {
            sql += " AND a.brandId.brandName =: brandName";
        }

        if (modelName != null) {
            sql += " AND a.modelId.modelName =: modelName";
        }

        if (cityName != null) {
            sql += " AND a.userId.cityId.cityName =: cityName";
        }

        if (banType != null) {
            sql += " AND a.banType =: banType";
        }

        if (mileage != null) {
            sql += " AND a.mileage =: mileage";
        }

        if (mileageType != null) {
            sql += " AND a.mileageType =: mileageType";
        }

        if (color != null) {
            sql += " AND a.color =: color";
        }

        if (price != null) {
            sql += " AND a.price =: price";
        }

        if (currency != null) {
            sql += " AND a.currency =: currency";
        }

        if (ownersNumber != null) {
            sql += " AND a.ownersNumber =: ownersNumber";
        }

        if (fuelType != null) {
            sql += " AND a.fuelType =: fuelType";
        }

        if (transmitter != null) {
            sql += " AND a.transmitter =: transmitter";
        }

        if (gearbox != null) {
            sql += " AND a.gearbox =: gearbox";
        }

        if (carYear != null) {
            sql += " AND a.carYear =: carYear";
        }

        if (engineVolume != null) {
            sql += " AND a.engineVolume =: engineVolume";
        }

        if (marketAddresses != null) {
            sql += " AND a.marketAddresses =: marketAddresses";
        }

        if (repair != null) {
            sql += " AND a.repair =: repair";
        }

        if (seatsNumber != null) {
            sql += " AND a.seatsNumber =: seatsNumber";
        }

        if (vendorType != null) {
            sql += " AND a.vendorType =: vendorType";
        }

        if (salesType != null) {
            sql += " AND a.salesType =: salesType";
        }

        Query q = entityManager.createQuery(sql);

        if (brandName != null) {
            q.setParameter("brandName", brandName);
        }

        if (modelName != null) {
            q.setParameter("modelName", modelName);
        }

        if (cityName != null) {
            q.setParameter("cityName", cityName);
        }

        if (banType != null) {
            q.setParameter("banType", banType);
        }

        if (mileage != null) {
            q.setParameter("mileage", mileage);
        }

        if (mileageType != null) {
            q.setParameter("mileageType", mileageType);
        }

        if (color != null) {
            q.setParameter("color", color);
        }

        if (price != null) {
            q.setParameter("price", price);
        }

        if (currency != null) {
            q.setParameter("currency", currency);
        }

        if (ownersNumber != null) {
            q.setParameter("ownersNumber", ownersNumber);
        }

        if (fuelType != null) {
            q.setParameter("fuelType", fuelType);
        }

        if (transmitter != null) {
            q.setParameter("transmitter", transmitter);
        }

        if (gearbox != null) {
            q.setParameter("gearbox", gearbox);
        }

        if (carYear != null) {
            q.setParameter("carYear", carYear);
        }

        if (engineVolume != null) {
            q.setParameter("engineVolume", engineVolume);
        }

        if (marketAddresses != null) {
            q.setParameter("marketAddresses", marketAddresses);
        }

        if (repair != null) {
            q.setParameter("repair", repair);
        }

        if (seatsNumber != null) {
            q.setParameter("seatsNumber", seatsNumber);
        }

        if (vendorType != null) {
            q.setParameter("vendorType", vendorType);
        }

        if (salesType != null) {
            q.setParameter("salesType", salesType);
        }

        List<Announcement> announcementList = q.getResultList();
        return announcementList;
    }


}