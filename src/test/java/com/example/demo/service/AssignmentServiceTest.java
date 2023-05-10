package com.example.demo.service;

import com.example.demo.service.dto.AssignmentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssignmentServiceTest {
    @Autowired
    private AssignmentService assignmentService;

    @Test
    void getAllAssignment() {
        System.out.println(assignmentService.getAllAssignment());
    }

    @Test
    void createAssignment(AssignmentDTO assignmentDTO, Long deptId, Long employeeId) {
        System.out.println(assignmentService.createAssignment(assignmentDTO, deptId, employeeId));
    }
}