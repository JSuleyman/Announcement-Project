package com.example.carproject.repositories;

import com.example.carproject.enums.BanType;
import com.example.carproject.enums.MileageType;
import com.example.carproject.models.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

}
