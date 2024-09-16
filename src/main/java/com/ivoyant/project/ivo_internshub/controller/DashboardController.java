package com.ivoyant.project.ivo_internshub.controller;

import com.ivoyant.project.ivo_internshub.entity.Announcement;
import com.ivoyant.project.ivo_internshub.entity.Holiday;
import com.ivoyant.project.ivo_internshub.entity.Employee;
import com.ivoyant.project.ivo_internshub.service.DashboardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Operation(summary = "Get all announcements", description = "Returns a list of all the announcements")
    @GetMapping("/announcements")
    public List<Announcement> getAllAnnouncements() {
        return dashboardService.getAllAnnouncements();
    }

    @Operation(summary = "Get all holidays", description = "Returns a list of all the holidays")
    @GetMapping("/holidays")
    public List<Holiday> getAllHolidays() {
        return dashboardService.getAllHolidays();
    }

    @Operation(summary = "Get all employees", description = "Returns a list of all employees")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return dashboardService.getAllEmployees();
    }

    @Operation(summary = "Get employee by ID", description = "Returns an employee based on the ID provided")
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getUserById(@PathVariable Long id) {
        Employee employee = dashboardService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(employee);
    }

    @Operation(summary = "Create a new announcement", description = "Adds a new announcement to the system")
    @PostMapping("/announcement")
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        return dashboardService.createAnnouncement(announcement);
    }

    @Operation(summary = "Create a new holiday", description = "Adds a new holiday to the system")
    @PostMapping("/holiday")
    public Holiday createHoliday(@RequestBody Holiday holiday) {
        return dashboardService.createHoliday(holiday);
    }

    @Operation(summary = "Create a new employee", description = "Adds a new employee to the system")
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return dashboardService.createEmployee(employee);
    }

    @Operation(summary = "Update an employee", description = "Updates the details of an existing employee based on the provided ID")
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
        return dashboardService.updateEmployee(id,employee);
    }

    @Operation(summary = "Update an announcement", description = "Updates the details of an existing announcement based on the provided ID")
    @PutMapping("/announcement/{id}")
    public Announcement updateAnnouncement(@PathVariable Long id,@RequestBody Announcement announcement) {
        return dashboardService.updateAnnouncement(id,announcement);
    }

    @Operation(summary = "Update a holiday", description = "Updates the details of an existing holiday based on the provided ID")
    @PutMapping("/holiday/{id}")
    public Holiday updateHoliday(@PathVariable Long id,@RequestBody Holiday holiday) {
        return dashboardService.updateHoliday(id,holiday);
    }

}
