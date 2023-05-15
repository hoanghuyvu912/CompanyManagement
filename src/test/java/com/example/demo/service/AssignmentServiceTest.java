package com.example.demo.service;

import com.example.demo.service.dto.AssignmentRestDTO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AssignmentServiceTest {
    @Autowired
    private AssignmentService assignmentService;

    @Test
    void getAllAssignment() {
        List<AssignmentRestDTO> tempList = assignmentService.getAllAssignment();
        assertTrue(tempList.size() > 0);
    }

    @Test
    void getAssignmentById() {

    }

    @Test
    void getAssignmentByNumberOfHourLessThan() {
    }

    @Test
    void getAssignmentByNumberOfHourLessThanEqual() {
    }

    @Test
    void getAssignmentByNumberOfHourGreaterThan() {
    }

    @Test
    void getAssignmentByNumberOfHourGreaterThanEqual() {
    }

    @Test
    void getAssignmentByNumberOfHourBetween() {
    }

    @Test
    void createAssignment() {
    }

    @Test
    void updateAssignment() {
    }

    @Test
    void deleteAssignment() {
    }
}