package com.example.announcementproject.controller;

import com.example.announcementproject.dto.AnnouncementSearchFilter;
import com.example.announcementproject.model.Announcement;
import com.example.announcementproject.service.inter.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping
    public ResponseEntity<List<Announcement>> findAll() {
        List<Announcement> announcements = announcementService.findAll();
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    @GetMapping("/announcement/{id}")
    public ResponseEntity<Announcement> findById(@PathVariable("id") Integer announcementId) {
        Announcement getAnnouncement = announcementService.getById(announcementId);
        return new ResponseEntity<>(getAnnouncement, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Announcement>> getSearch(AnnouncementSearchFilter announcementSearchFilter) {
        List<Announcement> announcements = announcementService.getSearch(announcementSearchFilter);
        return new ResponseEntity<>(announcements, HttpStatus.OK);
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
