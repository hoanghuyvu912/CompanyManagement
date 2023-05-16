package com.example.demo.service;

import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.dto.DepartmentRestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @Test
    void getAllDepartment() {
        List<DepartmentRestDTO> tempList = departmentService.getAllDepartment();
        assertTrue(tempList.size() > 0);
    }

    @Test
    void getDepartmentById() {
    }

    @Test
    void getDepartmentByDate() {
    }

    @Test
    void getDepartmentByDateAfter() {
    }

    @Test
    void getDepartmentByDateBefore() {
    }

    @Test
    void getDepartmentByStartDateBetween() {
    }

    @Test
    void getDepartmentByNameIgnoreCase() {
    }

    @Test
    void createDepartment() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
//        String tempStartDate = "1999/08/12";
//        LocalDate startDate = LocalDate.parse(tempStartDate, formatter);
//        DepartmentDTO departmentDTO = DepartmentDTO.builder()
//                .name("Fullstack Department")
//                .startDate(startDate)
//                .build();
//        DepartmentRestDTO departmentRestDTO = departmentService.createDepartment(departmentDTO);
//        assertNotNull(departmentRestDTO.getId());
    }

    @Test
    void updateDepartment() {
    }

    @Test
    void deleteDepartment() {
    }

    @Test
    void getDeptWithNumberOfProjectsGreaterThan() {
    }

    @Test
    void getDeptWithNumberOfEmployees() {
    }

    @Test
    void getDeptWithMaxNumOfEmployees() {
    }
}