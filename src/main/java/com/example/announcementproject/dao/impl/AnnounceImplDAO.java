package com.example.announcementproject.dao.impl;

import com.example.announcementproject.dao.inter.AnnounceDAO;
import com.example.announcementproject.dto.AnnouncementSearchFilter;
import com.example.announcementproject.model.Announcement;
import com.example.announcementproject.model.CarBrand;
import com.example.announcementproject.model.CarModel;
import com.example.announcementproject.model.User;
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
    public void createAnnouncement(Announcement c) {
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
                .setParameter(23, new User(c.getUser().getId()))
                .executeUpdate();
    }

    @Override
    public List<Announcement> getSearch(AnnouncementSearchFilter filter) {
        String sql = "SELECT a from Announcement a where 1=1";

        if (filter.getBrandName() != null) {
            sql += " AND a.brandId.brandName =: brandName";
        }

        if (filter.getModelName() != null) {
            sql += " AND a.modelId.modelName =: modelName";
        }

        if (filter.getCityName() != null) {
            sql += " AND a.userId.cityId.cityName =: cityName";
        }

        if (filter.getBanType() != null) {
            sql += " AND a.banType =: banType";
        }

        if (filter.getMileage() != null) {
            sql += " AND a.mileage =: mileage";
        }

        if (filter.getMileageType() != null) {
            sql += " AND a.mileageType =: mileageType";
        }

        if (filter.getColor() != null) {
            sql += " AND a.color =: color";
        }

        if (filter.getMinPrice() != null) {
            sql += " AND a.price >=: minPrice";
        }

        if (filter.getMaxPrice() != null) {
            sql += " AND a.price <=: maxPrice";
        }

        if (filter.getCurrency() != null) {
            sql += " AND a.currency =: currency";
        }

        if (filter.getOwnersNumber() != null) {
            sql += " AND a.ownersNumber =: ownersNumber";
        }

        if (filter.getFuelType() != null) {
            sql += " AND a.fuelType =: fuelType";
        }

        if (filter.getTransmitter() != null) {
            sql += " AND a.transmitter =: transmitter";
        }

        if (filter.getGearbox() != null) {
            sql += " AND a.gearbox =: gearbox";
        }

        if (filter.getMinYear() != null) {
            sql += " AND a.carYear >=: minYear";
        }

        if (filter.getMaxYear() != null) {
            sql += " AND a.carYear <=: maxYear";
        }

        if (filter.getMinEngineVolume() != null) {
            sql += " AND a.engineVolume >=: minEngineVolume";
        }

        if (filter.getMaxEngineVolume() != null) {
            sql += " AND a.engineVolume <=: maxEngineVolume";
        }

        if (filter.getMinEnginePower() != null) {
            sql += " AND a.enginePower >=: minEnginePower";
        }

        if (filter.getMaxEnginePower() != null) {
            sql += " AND a.enginePower <=: maxEnginePower";
        }

        if (filter.getMarketAddresses() != null) {
            sql += " AND a.marketAddresses =: marketAddresses";
        }

        if (filter.getRepair() != null) {
            sql += " AND a.repair =: repair";
        }

        if (filter.getSeatsNumber() != null) {
            sql += " AND a.seatsNumber =: seatsNumber";
        }

        if (filter.getVendorType() != null) {
            sql += " AND a.vendorType =: vendorType";
        }

        if (filter.getSalesTyp() != null) {
            sql += " AND a.salesType =: salesType";
        }

        Query q = entityManager.createQuery(sql);

        if (filter.getBrandName() != null) {
            q.setParameter("brandName", filter.getBrandName());
        }

        if (filter.getModelName() != null) {
            q.setParameter("modelName", filter.getModelName());
        }

        if (filter.getCityName() != null) {
            q.setParameter("cityName", filter);
        }

        if (filter.getBanType() != null) {
            q.setParameter("banType", filter.getBanType());
        }

        if (filter.getMileage() != null) {
            q.setParameter("mileage", filter.getMileage());
        }

        if (filter.getMileageType() != null) {
            q.setParameter("mileageType", filter.getMileageType());
        }

        if (filter.getColor() != null) {
            q.setParameter("color", filter.getColor());
        }

        if (filter.getMinPrice() != null) {
            q.setParameter("minPrice", filter.getMinPrice());
        }

        if (filter.getMaxPrice() != null) {
            q.setParameter("maxPrice", filter.getMaxPrice());
        }

        if (filter.getCurrency() != null) {
            q.setParameter("currency", filter.getCurrency());
        }

        if (filter.getOwnersNumber() != null) {
            q.setParameter("ownersNumber", filter.getOwnersNumber());
        }

        if (filter.getFuelType() != null) {
            q.setParameter("fuelType", filter.getFuelType());
        }

        if (filter.getTransmitter() != null) {
            q.setParameter("transmitter", filter.getTransmitter());
        }

        if (filter.getGearbox() != null) {
            q.setParameter("gearbox", filter.getGearbox());
        }

        if (filter.getMinYear() != null) {
            q.setParameter("minYear", filter.getMinYear());
        }

        if (filter.getMaxYear() != null) {
            q.setParameter("maxYear", filter.getMaxYear());
        }

        if (filter.getMinEnginePower() != null) {
            q.setParameter("minEngineVolume", filter.getMinEngineVolume());
        }

        if (filter.getMaxEngineVolume() != null) {
            q.setParameter("maxEngineVolume", filter.getMaxEngineVolume());
        }

        if (filter.getMinEnginePower() != null) {
            q.setParameter("minEnginePower", filter.getMinEnginePower());
        }

        if (filter.getMaxEnginePower() != null) {
            q.setParameter("maxEnginePower", filter.getMaxEnginePower());
        }

        if (filter.getMarketAddresses() != null) {
            q.setParameter("marketAddresses", filter.getMarketAddresses());
        }

        if (filter.getRepair() != null) {
            q.setParameter("repair", filter.getRepair());
        }

        if (filter.getSeatsNumber() != null) {
            q.setParameter("seatsNumber", filter.getSeatsNumber());
        }

        if (filter.getVendorType() != null) {
            q.setParameter("vendorType", filter.getVendorType());
        }

        if (filter.getSalesTyp() != null) {
            q.setParameter("salesType", filter.getSalesTyp());
        }

        List<Announcement> announcementList = q.getResultList();
        return announcementList;
    }


}
