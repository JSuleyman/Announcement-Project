package com.example.carproject.services.impl;

import com.example.carproject.daos.inter.AnnounceDAO;
import com.example.carproject.enums.*;
import com.example.carproject.exceptions.InCorrectPassword;
import com.example.carproject.exceptions.NotFoundAnnouncement;
import com.example.carproject.exceptions.NotFoundUser;
import com.example.carproject.models.Announcement;
import com.example.carproject.models.User;
import com.example.carproject.repositories.AnnouncementRepository;
import com.example.carproject.repositories.UserRepository;
import com.example.carproject.services.inter.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    AnnounceDAO announceDAO;

    AnnouncementRepository announcementRepository;
    UserRepository userRepository;

    @Autowired
    public AnnouncementServiceImpl(AnnounceDAO announceDAO, UserRepository userRepository, AnnouncementRepository createAnnounceRepository) {
        this.announceDAO = announceDAO;
        this.userRepository = userRepository;
        this.announcementRepository = createAnnounceRepository;
    }

    @Override
    public List<Announcement> getAll() {
        return announcementRepository.findAll();
    }

    @Override
    public Optional<Announcement> getById(Integer id) {

        if (announcementRepository.findById(id).isEmpty()) throw new NotFoundAnnouncement();{
            return announcementRepository.findById(id);
        }


    }

    @Override
    public List<Announcement> getSearch(String brandName, String modelName, String cityName, BanType banType, Integer mileage, MileageType mileageType, String color, Double price, Currency currency, OwnersNumber ownersNumber, FuelType fuelType, Transmitter transmitter, Gearbox gearbox, Integer carYear, Integer engineVolume, MarketAddresses marketAddresses, Repair repair, SeatsNumber seatsNumber, VendorType vendorType, SalesType salesType) {

        List<Announcement> announcementList = announceDAO.getSearch(brandName, modelName, cityName, banType, mileage, mileageType, color, price, currency, ownersNumber, fuelType, transmitter, gearbox, carYear, engineVolume, marketAddresses, repair, seatsNumber, vendorType, salesType);

        List<Announcement> announcements = new ArrayList<>();

        for (Announcement value : announcementList) {
            if (value.getUserId().getAccount().getVip()) {
                announcements.add(value);
            }
        }

        for (Announcement value : announcementList) {
            if (!value.getUserId().getAccount().getVip()) {
                announcements.add(value);
            }
        }

        return announcements;
    }

    @Override
    public void createAnnouncement(Announcement createAnnounce, Integer userId) {


        User user = userRepository.getUserById(userId);
        if (!(Objects.equals(createAnnounce.getUserId().getId(), userId) && user != null)) throw new NotFoundUser();
        {

                announceDAO.createAnnouncement(createAnnounce, userId);
        }
    }

    @Override
    public void updateAnnouncement(Integer id, Announcement updateAnnouncement) {

        Optional<Announcement> announcement = announcementRepository.findById(id);

        if (!announcement.isPresent()) throw new NotFoundAnnouncement();
        {

                    Announcement announcement1 = announcement.get();

                    announcement1.setMileage(updateAnnouncement.getMileage());
                    announcement1.setColor(updateAnnouncement.getColor());
                    announcement1.setPrice(updateAnnouncement.getPrice());
                    announcement1.setCurrency(updateAnnouncement.getCurrency());
                    announcement1.setRepair(updateAnnouncement.getRepair());
                    announcement1.setVendorType(updateAnnouncement.getVendorType());
                    announcement1.setSalesType(updateAnnouncement.getSalesType());
                    announcement1.setDescription(updateAnnouncement.getDescription());
                    announcement1.setVehicleEquip(updateAnnouncement.getVehicleEquip());

                    announcementRepository.save(announcement1);
            }
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Announcement> announcement = announcementRepository.findById(id);

        if (!announcement.isPresent()) throw new NotFoundAnnouncement();
        {
                announcementRepository.deleteById(id);
        }
    }
}
