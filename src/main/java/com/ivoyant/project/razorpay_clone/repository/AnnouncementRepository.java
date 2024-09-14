package com.ivoyant.project.razorpay_clone.repository;

import com.ivoyant.project.razorpay_clone.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
