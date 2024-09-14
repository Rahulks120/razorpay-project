package com.ivoyant.project.razorpay_clone.service;

import com.ivoyant.project.razorpay_clone.entity.Announcement;
import com.ivoyant.project.razorpay_clone.entity.Holiday;
import com.ivoyant.project.razorpay_clone.entity.Employee;
import com.ivoyant.project.razorpay_clone.repository.AnnouncementRepository;
import com.ivoyant.project.razorpay_clone.repository.HolidayRepository;
import com.ivoyant.project.razorpay_clone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Announcement saveAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }
    public Holiday saveHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}
