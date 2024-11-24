package com.springdatajpa.example.service;

import com.springdatajpa.example.model.Address;
import com.springdatajpa.example.model.Employee;
import com.springdatajpa.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee addEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }


    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);

    }


    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public String deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return "employee deleted";
    }

    public Employee updateEmployee(int id, Employee employee) {
        Optional<Employee> empOpt = employeeRepository.findById(id);
        if (empOpt.isEmpty()) {
            throw new RuntimeException("Employee not found");

        }
        Employee existingEmployee = empOpt.get();
        if (employee.getName() == null) {
            employee.setName(existingEmployee.getName());
        }

        if (employee.getAddress() == null) {
            employee.setAddress(existingEmployee.getAddress());
        } else {
            Address newAddress = employee.getAddress();
            newAddress.setId(existingEmployee.getAddress().getId());
        }
         return employeeRepository.save(employee);


    }
}
