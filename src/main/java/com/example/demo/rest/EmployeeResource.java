package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.dto.EmployeeDTO;
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
    public ResponseEntity<Employee> getEmployeeById(Long employeeId, Long deptId) {
        Optional<Employee> optionalEmployee = employeeService.getEmployeeById(employeeId, deptId);
        return ResponseEntity.ok(optionalEmployee.get());
    }


    @Override
    public ResponseEntity<Employee> createEmployee(EmployeeDTO employeeDTO, Long deptId) {
        Employee employee = employeeService.createEmployee(employeeDTO, deptId);
        return ResponseEntity.created(URI.create("/api/departments/" + deptId + "/employees/" + employee.getId())).body(employee);
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(EmployeeDTO employeeDTO, Long employeeId) {
        Employee employee = employeeService.updateEmployee(employeeDTO, employeeId);
        return ResponseEntity.ok().body(employee);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
}
