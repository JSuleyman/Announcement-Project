package com.example.announcementproject.repositories;

import com.example.announcementproject.models.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

}
