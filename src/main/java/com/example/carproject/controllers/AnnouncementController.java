package com.example.carproject.controllers;

import com.example.carproject.dto.AnnounceSearchDTO;
import com.example.carproject.enums.*;
import com.example.carproject.models.Announcement;
import com.example.carproject.services.inter.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/announce")
public class AnnouncementController {
    AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService createAnnounceService) {
        this.announcementService = createAnnounceService;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<AnnounceSearchDTO>> getAll() {
        List<Announcement> getAnnouncement = announcementService.getAll();
        List<AnnounceSearchDTO> announceSearchDTOS = new ArrayList<>();

        for (Announcement createAnnounce1 : getAnnouncement) {
            AnnounceSearchDTO announceSearchDTO = new AnnounceSearchDTO(createAnnounce1);
            announceSearchDTOS.add(announceSearchDTO);
        }
        return new ResponseEntity<>(announceSearchDTOS, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AnnounceSearchDTO> findById(@PathVariable Integer id) {
        Announcement getAnnouncement = announcementService.getById(id).orElseThrow();
        AnnounceSearchDTO announceSearchDTO = new AnnounceSearchDTO(getAnnouncement);
        return new ResponseEntity<>(announceSearchDTO, HttpStatus.OK);
    }

    @GetMapping("/getSearch")
    public ResponseEntity<List<AnnounceSearchDTO>> getSearch(@RequestParam(required = false) String brandName,
                                                             @RequestParam(required = false) String modelName, @RequestParam(required = false) BanType banType,
                                                             @RequestParam(required = false) Integer mileage, @RequestParam(required = false) MileageType mileageType,
                                                             @RequestParam(required = false) String color, @RequestParam(required = false) Double minPrice,
                                                             @RequestParam(required = false) Double maxPrice, @RequestParam(required = false) Currency currency,
                                                             @RequestParam(required = false) OwnersNumber ownersNumber, @RequestParam(required = false) FuelType fuelType,
                                                             @RequestParam(required = false) Transmitter transmitter, @RequestParam(required = false) Gearbox gearbox,
                                                             @RequestParam(required = false) Integer minYear, @RequestParam(required = false) Integer maxYear,
                                                             @RequestParam(required = false) Double minEngineVolume, @RequestParam(required = false) Double maxEngineVolume,
                                                             @RequestParam(required = false) Integer minEnginePower, @RequestParam(required = false) Integer maxEnginePower,
                                                             @RequestParam(required = false) MarketAddresses marketAddresses, @RequestParam(required = false) Repair repair,
                                                             @RequestParam(required = false) SeatsNumber seatsNumber, @RequestParam(required = false) VendorType vendorType,
                                                             @RequestParam(required = false) SalesType salesType, @RequestParam(required = false) String cityName) {

        List<Announcement> list = announcementService.getSearch(brandName, modelName, cityName, banType, mileage, mileageType, color, minPrice, maxPrice, currency, ownersNumber, fuelType, transmitter, gearbox, minYear, maxYear, minEngineVolume, maxEngineVolume, minEnginePower, maxEnginePower, marketAddresses, repair, seatsNumber, vendorType, salesType);
        List<AnnounceSearchDTO> announceSearchDTOS = new ArrayList<>();

        for (Announcement announcement : list) {
            AnnounceSearchDTO announceSearchDTO = new AnnounceSearchDTO(announcement);
            announceSearchDTOS.add(announceSearchDTO);
        }
        return new ResponseEntity<>(announceSearchDTOS, HttpStatus.OK);
    }

    @PostMapping("/addAnnouncement")
    public void createAnnouncement(@RequestBody Announcement createAnnounce, @RequestParam Integer userId) {
        announcementService.createAnnouncement(createAnnounce, userId);
    }

    @PutMapping("/updateAnnouncement/{id}")
    public void updateAnnouncement(@PathVariable Integer id, @RequestBody Announcement createAnnounce, @RequestParam String userName) {
        announcementService.updateAnnouncement(id, createAnnounce, userName);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam Integer id, @RequestParam String userName) {
        announcementService.deleteById(id, userName);
    }
}
