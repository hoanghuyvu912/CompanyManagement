package com.example.demo.service;

import com.example.demo.service.dto.DepartmentDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @Test
    void getAllDepartment() {
        System.out.println(departmentService.getAllDepartment());
    }

    @Test
    void createDepartment(DepartmentDTO departmentDTO) {
        System.out.println(departmentService.createDepartment(departmentDTO));
    }
}
