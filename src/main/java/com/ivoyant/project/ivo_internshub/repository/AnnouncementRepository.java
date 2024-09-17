package com.ivoyant.project.ivo_internshub.repository;

import com.ivoyant.project.ivo_internshub.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
