package com.example.announcementproject.services.impl;

import com.example.announcementproject.daos.inter.AnnounceDAO;
import com.example.announcementproject.dto.AnnouncementSearchFilter;
import com.example.announcementproject.exceptions.AnnouncementNotFoundException;
import com.example.announcementproject.exceptions.UserNotFoundException;
import com.example.announcementproject.models.Announcement;
import com.example.announcementproject.repositories.AnnouncementRepository;
import com.example.announcementproject.repositories.UserRepository;
import com.example.announcementproject.services.inter.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnounceDAO announceDAO;
    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;

    @Override
    public List<Announcement> findAll() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement getById(Integer announcementId) {
        return announcementRepository.findById(announcementId).stream()
                .findFirst()
                .orElseThrow(AnnouncementNotFoundException::new);
    }

    @Override
    public List<Announcement> getSearch(AnnouncementSearchFilter filter) {
        return announceDAO.getSearch(filter);
    }

    @Override
    public void create(Announcement createAnnounce) {
        userRepository.getUserById(createAnnounce.getUser().getId()).stream()
                .findFirst()
                .orElseThrow(UserNotFoundException::new);

        announceDAO.createAnnouncement(createAnnounce);
    }

    @Override
    public void update(Integer announcementId, Announcement updateAnnouncement, String userName) {
        Announcement announcement = announcementRepository.findById(announcementId).stream()
                .findFirst()
                .orElseThrow(AnnouncementNotFoundException::new);

        if (announcement.getUser().getName().equals(userName)) {
            announcement.setMileage(updateAnnouncement.getMileage());
            announcement.setColor(updateAnnouncement.getColor());
            announcement.setPrice(updateAnnouncement.getPrice());
            announcement.setCurrency(updateAnnouncement.getCurrency());
            announcement.setRepair(updateAnnouncement.getRepair());
            announcement.setVendorType(updateAnnouncement.getVendorType());
            announcement.setSalesType(updateAnnouncement.getSalesType());
            announcement.setDescription(updateAnnouncement.getDescription());
            announcement.setVehicleEquip(updateAnnouncement.getVehicleEquip());

            announcementRepository.save(announcement);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public void deleteById(Integer announcementId, String userName) {
        Announcement announcement = announcementRepository.findById(announcementId).stream()
                .findFirst()
                .orElseThrow(AnnouncementNotFoundException::new);

        if (announcement.getUser().getName().equals(userName)) {
            announcementRepository.deleteById(announcementId);
        } else {
            throw new UserNotFoundException();
        }
    }
}
