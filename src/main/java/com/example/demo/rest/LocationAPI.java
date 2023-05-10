package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Location;
import com.example.demo.service.dto.EmployeeDTO;
import com.example.demo.service.dto.LocationDTO;
import com.example.demo.service.dto.LocationRestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/departments/{deptId}/locations")
public interface LocationAPI {
    @GetMapping(value = "/{locationId}")
    ResponseEntity<LocationRestDTO> getLocationById(@PathVariable("locationId") Long locationId, @PathVariable("deptId") Long deptId);

    @PostMapping
    ResponseEntity<Location> createLocation(@RequestBody LocationDTO locationDTO, @PathVariable("deptId") Long deptId);


    @PutMapping(value = "/{locationId}")
    ResponseEntity<Location> updateLocation(@RequestBody LocationDTO locationDTO, @PathVariable("deptId") Long deptId, @PathVariable("locationId") Long locationId);

    @DeleteMapping(value = "/{locationId}")
    ResponseEntity<Void> deleteLocation(@PathVariable("locationId") Long locationId);
}
