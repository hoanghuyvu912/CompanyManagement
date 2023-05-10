package com.example.demo.service;

import com.example.demo.service.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;

    @Test
    void getAllEmployee() {
        System.out.println(employeeService.getAllEmployee());
    }

    @Test
    void createEmployee(EmployeeDTO employeeDTO, Long deptId) {
        System.out.println(employeeService.createEmployee(employeeDTO, deptId));
    }
}