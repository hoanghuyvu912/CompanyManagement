package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.dto.DepartmentRestDTO;
import com.example.demo.service.dto.DepartmentWithNumOfEmployeeDTO;
import com.example.demo.service.dto.DepartmentWithNumOfProjectsDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping(value = "/api/departments")
public interface DepartmentAPI {
    @GetMapping(value = "/{deptId}")
    ResponseEntity<DepartmentRestDTO> getDepartmentById(@PathVariable Long deptId);

    @GetMapping(value = "/reports")
    ResponseEntity<List<DepartmentRestDTO>> getDepartmentByStartDate(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);

    @GetMapping(value = "/reports_after")
    ResponseEntity<List<DepartmentRestDTO>> getDepartmentByStartDateAfter(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);

    @GetMapping(value = "/reports_before")
    ResponseEntity<List<DepartmentRestDTO>> getDepartmentByStartDateBefore(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);

    @GetMapping(value = "/reports_between")
    ResponseEntity<List<DepartmentRestDTO>> getDepartmentByStartDateBetween(@Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate,
                                                                     @Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @GetMapping(value = "/string_pattern")
    ResponseEntity<List<DepartmentRestDTO>> getDepartmentByNameIgnoreCase(@RequestParam("name") String name);

    @PostMapping
    ResponseEntity<DepartmentRestDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO);

    @PutMapping(value = "/{deptId}")
    ResponseEntity<DepartmentRestDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable Long deptId);

    @DeleteMapping(value = "/{deptId}")
    ResponseEntity<Void> deleteDepartment(@PathVariable Long deptId);


    @GetMapping(value = "/getDeptWithNumberOfProjectsGreaterThan")
    ResponseEntity<List<DepartmentWithNumOfProjectsDTO>> getDeptWithNumberOfProjectsGreaterThan(@RequestParam("num") Long num);

    @GetMapping(value = "/getDeptWithNumberOfEmployees")
    ResponseEntity<List<DepartmentWithNumOfEmployeeDTO>> getDeptWithNumberOfEmployees();

    @GetMapping(value = "/getDeptWithMaxNumOfEmployees")
    ResponseEntity<List<DepartmentWithNumOfEmployeeDTO>> getDeptWithMaxNumOfEmployees();

//    @GetMapping(value = "/getDeptWithNumberOfEmployeesGreaterThan")
//    ResponseEntity<List<DepartmentWithNumOfEmployeeDTO>> getDeptWithNumberOfEmployeesGreaterThan(@RequestParam("num") Long num);

}
