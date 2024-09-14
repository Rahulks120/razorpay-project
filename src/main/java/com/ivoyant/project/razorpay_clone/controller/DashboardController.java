package com.ivoyant.project.razorpay_clone.controller;

import com.ivoyant.project.razorpay_clone.entity.Announcement;
import com.ivoyant.project.razorpay_clone.entity.Holiday;
import com.ivoyant.project.razorpay_clone.entity.Employee;
import com.ivoyant.project.razorpay_clone.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/announcements")
    public List<Announcement> getAllAnnouncements() {
        return dashboardService.getAllAnnouncements();
    }

    @GetMapping("/holidays")
    public List<Holiday> getAllHolidays() {
        return dashboardService.getAllHolidays();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getUserById(@PathVariable String id) {
        Employee employee = dashboardService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/announcement")
    public Announcement createOrUpdateAnnouncement(@RequestBody Announcement announcement) {
        return dashboardService.saveAnnouncement(announcement);
    }

    @PostMapping("/holiday")
    public Holiday createOrUpdateHoliday(@RequestBody Holiday holiday) {
        return dashboardService.saveHoliday(holiday);
    }

    @PostMapping("/employee")
    public Employee createUser(@RequestBody Employee employee) {
        return dashboardService.saveEmployee(employee);
    }

}
