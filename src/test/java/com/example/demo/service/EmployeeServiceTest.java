package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    void getAllEmployee() {
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void getEmployeeByLastNameAndFirstName() {
    }

    @Test
    void getEmployeeByLastNameOrFirstName() {
    }

    @Test
    void getEmployeeByFirstName() {
    }

    @Test
    void getEmployeeBySalaryLessThan() {
    }

    @Test
    void getEmployeeBySalaryGreaterThan() {
    }

    @Test
    void createEmployee() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void getEmployeesByDepartmentId() {
    }
}