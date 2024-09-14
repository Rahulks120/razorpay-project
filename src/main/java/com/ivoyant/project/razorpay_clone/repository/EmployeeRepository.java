package com.ivoyant.project.razorpay_clone.repository;


import com.ivoyant.project.razorpay_clone.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}

