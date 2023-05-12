package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Location;
import com.example.demo.exception.CompanyManagementException;
import com.example.demo.respository.DepartmentRepository;
import com.example.demo.respository.LocationRepository;
import com.example.demo.service.dto.LocationDTO;
import com.example.demo.service.dto.LocationRestDTO;
import com.example.demo.service.mapper.LocationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final DepartmentRepository departmentRepository;
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public List<LocationRestDTO> getAllLocation() {
        return locationMapper.toRestDTOs(locationRepository.findAll());
    }

    public LocationRestDTO getLocationById(Long locationId, Long deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(CompanyManagementException::DepartmentNotFound);
        Location location = locationRepository.findById(locationId).orElseThrow(CompanyManagementException::LocationNotFound);
        return locationMapper.toRestDTO(location);
    }

    public List<LocationRestDTO> getLocationByLocationLike(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search String is missing.");
        }
        return locationMapper.toRestDTOs(locationRepository.findByLocationLike("%" + s + "%"));
    }

    public List<LocationRestDTO> getLocationByLocationNotLike(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search String is missing.");
        }
        return locationMapper.toRestDTOs(locationRepository.findByLocationNotLike("%" + s + "%"));
    }

    public List<LocationRestDTO> getLocationByLocationStartingWith(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search String is missing.");
        }
        return locationMapper.toRestDTOs(locationRepository.findByLocationStartingWith(s));
    }

    public List<LocationRestDTO> getLocationByLocationEndingWith(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search String is missing.");
        }
        return locationMapper.toRestDTOs(locationRepository.findByLocationEndingWith(s));
    }

    public List<LocationRestDTO> getLocationByLocationContaining(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search String is missing.");
        }
        return locationMapper.toRestDTOs(locationRepository.findByLocationContaining(s));
    }


    public Location createLocation(LocationDTO locationDTO, Long depIt) {
        Optional<Department> department = departmentRepository.findById(depIt);
        Location location = new Location();

        if (locationDTO.getLocation() == null || locationDTO.getLocation().trim().isBlank() || locationDTO.getLocation().isEmpty()) {
            throw CompanyManagementException.badRequest("LocationNameMissing", "Location name is missing.");
        }

        location.setLocation(locationDTO.getLocation());
        if (department.isPresent()) {
            location.setDepartment(department.get());
        }
        return locationRepository.save(location);
    }

    public void deleteLocation(Long locationId) {
        locationRepository.deleteById(locationId);
    }

    public LocationRestDTO updateLocation(LocationDTO locationDTO, Long locationId) {
        Location location = locationRepository.findById(locationId).orElseThrow(CompanyManagementException::LocationNotFound);
        if (locationDTO.getLocation() == null || locationDTO.getLocation().trim().isBlank() || locationDTO.getLocation().isEmpty()) {
            throw CompanyManagementException.badRequest("LocationNameMissing", "Location name is missing.");
        }
        location.setLocation(locationDTO.getLocation());
        return locationMapper.toRestDTO(locationRepository.save(location));
    }
}
