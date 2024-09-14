package com.ivoyant.project.razorpay_clone.repository;

import com.ivoyant.project.razorpay_clone.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {
}
