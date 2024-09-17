package com.ivoyant.project.ivo_internshub.repository;

import com.ivoyant.project.ivo_internshub.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {
}
