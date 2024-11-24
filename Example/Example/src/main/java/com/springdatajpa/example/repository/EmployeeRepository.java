package com.springdatajpa.example.repository;

import com.springdatajpa.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
