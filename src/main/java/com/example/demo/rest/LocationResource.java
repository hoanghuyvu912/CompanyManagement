package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;
import com.example.demo.service.dto.LocationDTO;
import com.example.demo.service.dto.LocationRestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LocationResource implements LocationAPI {
    private final LocationService locationService;

    @Override
    public ResponseEntity<LocationRestDTO> getLocationById(Long locationId, Long deptId) {
        LocationRestDTO locationRestDTO = locationService.getLocationById(locationId, deptId);
        return ResponseEntity.ok(locationRestDTO);
    }

    @Override
    public ResponseEntity<Location> createLocation(LocationDTO locationDTO, Long deptId) {
        Location location = locationService.createLocation(locationDTO, deptId);
        return ResponseEntity.created(URI.create("/api/dept" + deptId + "/location" + location.getId())).body(location);
    }


    @Override
    public ResponseEntity<LocationRestDTO> updateLocation(LocationDTO locationDTO, Long deptId, Long locationId) {
        LocationRestDTO locationRestDTO = locationService.updateLocation(locationDTO, locationId);
        return ResponseEntity.ok().body(locationRestDTO);
    }

    @Override
    public ResponseEntity<Void> deleteLocation(Long locationId) {
        return null;
    }
}
