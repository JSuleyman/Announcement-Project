package com.example.announcementproject.controllers;

import com.example.announcementproject.dto.AnnounceSearchDTO;
import com.example.announcementproject.dto.AnnouncementSearchFilter;
import com.example.announcementproject.models.Announcement;
import com.example.announcementproject.services.inter.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/announcements")
@RequiredArgsConstructor
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @GetMapping
    public ResponseEntity<List<AnnounceSearchDTO>> findAll() {
        List<Announcement> announcements = announcementService.findAll();
        List<AnnounceSearchDTO> announceSearchDTOS = new ArrayList<>();

        for (Announcement createAnnounce : announcements) {
            AnnounceSearchDTO announceSearchDTO = new AnnounceSearchDTO(createAnnounce);
            announceSearchDTOS.add(announceSearchDTO);
        }

        return new ResponseEntity<>(announceSearchDTOS, HttpStatus.OK);
    }

    @GetMapping("/announcement/{id}")
    public ResponseEntity<AnnounceSearchDTO> findById(@PathVariable("id") Integer announcementId) {
        Announcement getAnnouncement = announcementService.getById(announcementId);
        AnnounceSearchDTO announceSearchDTO = new AnnounceSearchDTO(getAnnouncement);
        return new ResponseEntity<>(announceSearchDTO, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<AnnounceSearchDTO>> getSearch(AnnouncementSearchFilter announcementSearchFilter) {
        List<Announcement> announcements = announcementService.getSearch(announcementSearchFilter);
        List<AnnounceSearchDTO> announceSearchDtoList = new ArrayList<>();

        for (Announcement announcement : announcements) {
            AnnounceSearchDTO announceSearchDTO = new AnnounceSearchDTO(announcement);
            announceSearchDtoList.add(announceSearchDTO);
        }

        return new ResponseEntity<>(announceSearchDtoList, HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody Announcement createAnnounce) {
        announcementService.create(createAnnounce);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer announcementId,
                       @RequestBody Announcement createAnnounce,
                       @RequestParam String userName) {
        announcementService.update(announcementId, createAnnounce, userName);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer announcementId, @RequestParam String userName) {
        announcementService.deleteById(announcementId, userName);
    }
}
