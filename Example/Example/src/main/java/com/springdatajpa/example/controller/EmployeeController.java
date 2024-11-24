package com.springdatajpa.example.controller;


import com.springdatajpa.example.model.Employee;

import com.springdatajpa.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    EmployeeService empService;
    @Autowired
    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }




    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {

        return empService.addEmployee(employee);
    }


    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return empService.getEmployee(id);
    }


    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees(){
        return empService.getAllEmployee();
    }


    @DeleteMapping("/deleteEmployee/{id}")
    public String delete(@PathVariable  Integer id){
        return empService.deleteEmployee(id);
    }


    @PutMapping("/updateEmployee/{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee employee){
        return  empService.updateEmployee(id,employee);

    }
}
