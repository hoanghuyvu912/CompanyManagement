package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.dto.EmployeeDTO;
import com.example.demo.service.dto.EmployeeRestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EmployeeResource implements EmployeeAPI {
    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeRestDTO> getEmployeeById(Long employeeId, Long deptId) {
        EmployeeRestDTO employeeRestDTO = employeeService.getEmployeeById(employeeId, deptId);
        return ResponseEntity.ok(employeeRestDTO);
    }

    @Override
    public ResponseEntity<EmployeeRestDTO> createEmployee(EmployeeDTO employeeDTO, Long deptId) {
        EmployeeRestDTO employeeRestDTO = employeeService.createEmployee(employeeDTO, deptId);
        return ResponseEntity.created(URI.create("/api/departments/" + deptId + "/employees/" + employeeRestDTO.getId())).body(employeeRestDTO);
    }

    @Override
    public ResponseEntity<EmployeeRestDTO> updateEmployee(EmployeeDTO employeeDTO, Long employeeId) {
        EmployeeRestDTO employeeRestDTO = employeeService.updateEmployee(employeeDTO, employeeId);
        return ResponseEntity.ok().body(employeeRestDTO);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
}
