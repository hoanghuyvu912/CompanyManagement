package com.example.demo.rest;

import com.example.demo.entity.*;
import com.example.demo.service.dto.*;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping(value = "/api/company")
public interface CompanyAPI {
    //Employee
    @GetMapping(value = "/employees")
    ResponseEntity<List<EmployeeRestDTO>> getAllEmployee();

    @GetMapping(value = "/employees/lastNameAndFirstName")
    ResponseEntity<List<EmployeeRestDTO>> getEmployeeByLastNameAndFirstName(@Param("lastName") String lastName, @Param("firstName") String firstName);

    @GetMapping(value = "/employees/lastNameOrFirstName")
    ResponseEntity<List<EmployeeRestDTO>> getEmployeeByLastNameOrFirstName(@Param("lastName") String lastName, @Param("firstName") String firstName);

    @GetMapping(value = "/employees/firstName")
    ResponseEntity<List<EmployeeRestDTO>> getEmployeeByFirstName(@RequestParam("firstName") String firstName);

    @GetMapping(value = "/employees/salaryLessThan")
    ResponseEntity<List<EmployeeRestDTO>> getEmployeeBySalaryLessThan(@RequestParam("salary") String salary);

    @GetMapping(value = "/employees/salaryGreaterThan")
    ResponseEntity<List<EmployeeRestDTO>> getEmployeeBySalaryGreaterThan(@RequestParam("salary") String salary);

    //Department
    @GetMapping(value = "/departments")
    ResponseEntity<List<DepartmentRestDTO>> getAllDepartment();

    @GetMapping(value = "/departments/{deptId}/employees")
    ResponseEntity<List<EmployeeRestDTO>> getEmployeesByDeptId(@PathVariable("deptId") Long deptId);

    //Location
    @GetMapping(value = "/locations")
    ResponseEntity<List<LocationRestDTO>> getAllLocation();

    @GetMapping(value = "/locations/location_like")
    ResponseEntity<List<LocationRestDTO>> getLocationByLocationLike(@RequestParam("location") String location);

    @GetMapping(value = "/locations/location_not_like")
    ResponseEntity<List<LocationRestDTO>> getLocationByLocationNotLike(@RequestParam("location") String location);

    @GetMapping(value = "/locations/location_starting_with")
    ResponseEntity<List<LocationRestDTO>> getLocationByLocationStartingWith(@RequestParam("location") String location);

    @GetMapping(value = "/locations/location_ending_with")
    ResponseEntity<List<LocationRestDTO>> getLocationByLocationEndingWith(@RequestParam("location") String location);

    @GetMapping(value = "/locations/location_containing")
    ResponseEntity<List<LocationRestDTO>> getLocationByLocationContaining(@RequestParam("location") String location);


    //Project
    @GetMapping(value = "/projects")
    ResponseEntity<List<ProjectRestDTO>> getAllProject();

    @GetMapping(value = "/projects/name_not")
    ResponseEntity<List<ProjectRestDTO>> getProjectByProjectNameNot(@RequestParam("name") String name);

    @GetMapping(value = "/projects/area_null")
    ResponseEntity<List<ProjectRestDTO>> getProjectByAreaIsNull();

    @GetMapping(value = "/projects/area_ignore_case/")
    ResponseEntity<List<ProjectRestDTO>> getProjectByAreaIgnoreCase(@RequestParam("area") String area, @PathParam("deptId") Long deptId);

    @GetMapping(value = "/projects/area_not_null")
    ResponseEntity<List<ProjectRestDTO>> getProjectByAreaNotNull();

    @GetMapping(value = "/projects/projects_order_by_name")
    ResponseEntity<List<ProjectRestDTO>> getAllProjectOrderByName();

    //Relatives
    @GetMapping(value = "/relatives")
    ResponseEntity<List<RelativesRestDTO>> getAllRelative();

    @GetMapping(value = "/relatives_order_by_full_name")
    ResponseEntity<List<RelativesRestDTO>> getAllRelativesOrderByFullName();

    @GetMapping(value = "/relatives/start_with")
    ResponseEntity<List<RelativesRestDTO>> getRelativesByFullNameStartingWith(@RequestParam String string);

    @GetMapping(value = "/relatives/ending_with")
    ResponseEntity<List<RelativesRestDTO>> getRelativesByFullNameEndingWith(@RequestParam String string);

    @GetMapping(value = "/relatives/phone_number_containing")
    ResponseEntity<List<RelativesRestDTO>> getRelativesByPhoneNumberContaining(@RequestParam String string);

    @GetMapping(value = "/relatives/relationship")
    ResponseEntity<List<RelativesRestDTO>> getRelativesByRelationshipEquals(@RequestParam String string);

    @GetMapping(value = "/employees/{employeeId}/relatives")
    ResponseEntity<List<RelativesRestDTO>> getRelativesByEmployeeId(@PathVariable("employeeId") Long employeeId);

    //Assignment
    @GetMapping(value = "/assignments")
    ResponseEntity<List<AssignmentRestDTO>> getAllAssignment();

    @GetMapping(value = "/assignments/hour_less_than")
    ResponseEntity<List<AssignmentRestDTO>> getAssignmentByNumberOfHourLessThan(@RequestParam("hour") String hour);

    @GetMapping(value = "/assignments/hour_less_than_equal")
    ResponseEntity<List<AssignmentRestDTO>> getAssignmentByNumberOfHourLessThanEqual(@RequestParam("hour") String hour);

    @GetMapping(value = "/assignments/hour_greater_than")
    ResponseEntity<List<AssignmentRestDTO>> getAssignmentByNumberOfHourGreaterThan(@RequestParam("hour") String hour);

    @GetMapping(value = "/assignments/hour_greater_than_equal")
    ResponseEntity<List<AssignmentRestDTO>> getAssignmentByNumberOfHourGreaterThanEqual(@RequestParam("hour") String hour);

    @GetMapping(value = "/assignments/hour_between")
    ResponseEntity<List<AssignmentRestDTO>> getAssignmentByNumberOfHourBetween(@Param("hour") String hour1, @Param("hour") String hour2);


    @GetMapping(value = "/assignments/by_employee_id")
    ResponseEntity<List<AssignmentRestDTO>> getByEmployeeId(@RequestParam("employeeId") Long employeeId);
}
