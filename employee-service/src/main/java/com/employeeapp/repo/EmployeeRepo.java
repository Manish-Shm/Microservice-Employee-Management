package com.employeeapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeapp.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
