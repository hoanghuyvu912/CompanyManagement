package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.EmployeeDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/departments/{deptId}/employees")
public interface EmployeeAPI {

    @GetMapping(value = "/{employeeId}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Long employeeId, @PathVariable("deptId") Long deptId);

    @PostMapping
    ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("deptId") Long deptId);

    @PutMapping(value = "/{employeeId}")
    ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("employeeId") Long employeeId);

    @DeleteMapping(value = "/{employeeId}")
    ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") Long employeeId);
}
