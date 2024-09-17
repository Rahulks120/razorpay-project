package com.ivoyant.project.ivo_internshub.service;

import com.ivoyant.project.ivo_internshub.entity.Announcement;
import com.ivoyant.project.ivo_internshub.entity.Holiday;
import com.ivoyant.project.ivo_internshub.entity.Employee;
import com.ivoyant.project.ivo_internshub.exceptions.EmployeeIdAlreadyExistsException;
import com.ivoyant.project.ivo_internshub.exceptions.ResourceNotFoundException;
import com.ivoyant.project.ivo_internshub.repository.AnnouncementRepository;
import com.ivoyant.project.ivo_internshub.repository.HolidayRepository;
import com.ivoyant.project.ivo_internshub.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        log.info("Finding Employee with id :" + id);
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            log.error("Employee not found with ID :" + id);
            throw new ResourceNotFoundException("Employee not found with ID :" + id);
        }
        log.info("Found Employee with id :" + id);
        return employee;
    }

    public Announcement createAnnouncement(Announcement announcement) {
        log.info("Creating Announcement");
        return announcementRepository.save(announcement);
    }

    public Holiday createHoliday(Holiday holiday) {
        log.info("Creating Holiday");
        return holidayRepository.save(holiday);
    }

    public Employee createEmployee(Employee employee) {
        log.info("Checking if employee already exists with id:" + employee.getId());
        boolean isExists=employeeRepository.existsById(employee.getId());
        if(isExists) {
            log.error("Employee already exists with id:" + employee.getId());
            throw new EmployeeIdAlreadyExistsException("Employee already exists with id:" + employee.getId());
        }
        log.info("Employee created with id:" + employee.getId());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        boolean isExists = employeeRepository.existsById(id);
        if (!isExists) {
            log.error("Employee not present with id :"+ id );
            throw new ResourceNotFoundException("Employee not present with id :"+ id);
        } else {
            log.info("Updated employee with id:"+id);
            Employee updatedEmployee = employeeRepository.findById(id).orElse(null);
            updatedEmployee.setName(employee.getName());
            updatedEmployee.setRole(employee.getRole());
            updatedEmployee.setManager(employee.getManager());
            return employeeRepository.save(updatedEmployee);
        }
    }

    public Announcement updateAnnouncement(Long id, Announcement announcement) {
        boolean isExists = announcementRepository.existsById(id);
        if (!isExists) {
            log.error("Announcement not present with id :"+ id );
            throw new ResourceNotFoundException("Announcement not present with id :"+ id);
        } else {
            log.info("Updated Announcement with id:"+id);
            Announcement updatedAnnouncement = announcementRepository.findById(id).orElse(null);
            updatedAnnouncement.setDate(announcement.getDate());
            updatedAnnouncement.setMessage(announcement.getMessage());
            return announcementRepository.save(updatedAnnouncement);
        }
    }

    public Holiday updateHoliday(Long id, Holiday holiday) {
        boolean isExists = holidayRepository.existsById(id);
        if (!isExists) {
            log.error("Holiday not present with id :"+ id );
            throw new ResourceNotFoundException("Holiday not present with id :"+ id);
        } else {
            log.info("Updated holiday with id:"+id);
            Holiday updatedHoliday = holidayRepository.findById(id).orElse(null);
            updatedHoliday.setDate(holiday.getDate());
            updatedHoliday.setName(holiday.getName());
            return holidayRepository.save(updatedHoliday);
        }
    }

}
