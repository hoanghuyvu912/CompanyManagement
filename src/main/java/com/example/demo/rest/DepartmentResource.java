package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.dto.DepartmentRestDTO;
import com.example.demo.service.dto.DepartmentWithNumOfEmployeeDTO;
import com.example.demo.service.dto.DepartmentWithNumOfProjectsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class DepartmentResource implements DepartmentAPI {
    private final DepartmentService departmentService;

    @Override
    public ResponseEntity<DepartmentRestDTO> getDepartmentById(Long deptId) {
//        Optional<Department> optionDepartment = departmentService.getDepartmentById(deptId);
        return ResponseEntity.ok(departmentService.getDepartmentById(deptId));
    }

    @Override
    public ResponseEntity<List<DepartmentRestDTO>> getDepartmentByStartDate(LocalDate startDate) {
        return ResponseEntity.ok(departmentService.getDepartmentByDate(startDate));
    }

    @Override
    public ResponseEntity<List<DepartmentRestDTO>> getDepartmentByStartDateAfter(LocalDate startDate) {
        return ResponseEntity.ok(departmentService.getDepartmentByDateAfter(startDate));
    }

    @Override
    public ResponseEntity<List<DepartmentRestDTO>> getDepartmentByStartDateBefore(LocalDate startDate) {
        return ResponseEntity.ok(departmentService.getDepartmentByDateBefore(startDate));
    }

    @Override
    public ResponseEntity<List<DepartmentRestDTO>> getDepartmentByStartDateBetween(LocalDate beginDate, LocalDate endDate) {
        return ResponseEntity.ok(departmentService.getDepartmentByStartDateBetween(beginDate, endDate));
    }

    @Override
    public ResponseEntity<List<DepartmentRestDTO>> getDepartmentByNameIgnoreCase(String name) {
        return ResponseEntity.ok(departmentService.getDepartmentByNameIgnoreCase(name));
    }

    @Override
    public ResponseEntity<DepartmentRestDTO> createDepartment(DepartmentDTO departmentDTO) {
        return ResponseEntity.ok(departmentService.createDepartment(departmentDTO));
    }

    @Override
    public ResponseEntity<DepartmentRestDTO> updateDepartment(DepartmentDTO departmentDTO, Long deptId) {
        DepartmentRestDTO departmentRestDTO = departmentService.updateDepartment(departmentDTO, deptId);
        return ResponseEntity.ok().body(departmentRestDTO);
    }

    @Override
    public ResponseEntity<Void> deleteDepartment(Long deptId) {
        departmentService.deleteDepartment(deptId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<DepartmentWithNumOfProjectsDTO>> getDeptWithNumberOfProjectsGreaterThan(Long num) {
        return ResponseEntity.ok(departmentService.getDeptWithNumberOfProjectsGreaterThan(num));
    }

    @Override
    public ResponseEntity<List<DepartmentWithNumOfEmployeeDTO>> getDeptWithNumberOfEmployees() {
        return ResponseEntity.ok(departmentService.getDeptWithNumberOfEmployees());
    }

    @Override
    public ResponseEntity<List<DepartmentWithNumOfEmployeeDTO>> getDeptWithMaxNumOfEmployees() {
        return ResponseEntity.ok(departmentService.getDeptWithMaxNumOfEmployees());
    }

//    @Override
//    public ResponseEntity<List<DepartmentWithNumOfEmployeeDTO>> getDeptWithNumberOfEmployeesGreaterThan(Long num) {
//        return ResponseEntity.ok(departmentService.getDeptWithNumberOfEmployeesGreaterThan(num));
//    }
}
