package com.example.announcementproject.daos.inter;

import com.example.announcementproject.dto.AnnouncementSearchFilter;
import com.example.announcementproject.models.Announcement;

import java.util.List;

public interface AnnounceDAO {
    void createAnnouncement(Announcement c);

    List<Announcement> getSearch(AnnouncementSearchFilter filter);
}
