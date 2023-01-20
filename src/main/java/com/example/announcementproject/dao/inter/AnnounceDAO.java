package com.example.announcementproject.dao.inter;

import com.example.announcementproject.dto.AnnouncementSearchFilter;
import com.example.announcementproject.model.Announcement;

import java.util.List;

public interface AnnounceDAO {
    void createAnnouncement(Announcement c);

    List<Announcement> getSearch(AnnouncementSearchFilter filter);
}
