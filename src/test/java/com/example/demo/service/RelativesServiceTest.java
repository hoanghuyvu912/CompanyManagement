package com.example.demo.service;

import com.example.demo.service.dto.RelativesDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RelativesServiceTest {
    @Autowired
    RelativesService relativesService;

    @Test
    void getAllRelatives() {
        System.out.println(relativesService.getAllRelatives());
    }

    @Test
    void createRelatives(RelativesDTO relativesDTO, Long employeeId) {
        System.out.println(relativesService.createRelatives(relativesDTO, employeeId));
    }
}