package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.EmployeeDTO;
import com.example.demo.service.dto.EmployeeRestDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/departments/{deptId}/employees")
public interface EmployeeAPI {

    @GetMapping(value = "/{employeeId}")
    ResponseEntity<EmployeeRestDTO> getEmployeeById(@PathVariable("employeeId") Long employeeId, @PathVariable("deptId") Long deptId);

    @PostMapping
    ResponseEntity<EmployeeRestDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("deptId") Long deptId);

    @PutMapping(value = "/{employeeId}")
    ResponseEntity<EmployeeRestDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("employeeId") Long employeeId);

    @DeleteMapping(value = "/{employeeId}")
    ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") Long employeeId);
}
