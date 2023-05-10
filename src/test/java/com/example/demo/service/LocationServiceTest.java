package com.example.demo.service;

import com.example.demo.service.dto.LocationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocationServiceTest {
    @Autowired
    LocationService locationService;

    @Test
    void getAllLocation() {
        System.out.println(locationService.getAllLocation());
    }

    @Test
    void createLocation(LocationDTO locationDTO, Long deptId) {
        System.out.println(locationService.createLocation(locationDTO, deptId));
    }
}