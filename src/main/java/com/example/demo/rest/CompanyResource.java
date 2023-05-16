package com.example.demo.rest;

import com.example.demo.entity.*;
import com.example.demo.exception.CompanyManagementException;
import com.example.demo.service.*;
import com.example.demo.service.dto.*;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.description.field.FieldDescription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyResource implements CompanyAPI {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final LocationService locationService;
    private final ProjectService projectService;
    private final RelativesService relativesService;
    private final AssignmentService assignmentService;

    //Employee
    @Override
    public ResponseEntity<List<EmployeeRestDTO>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @Override
    public ResponseEntity<List<EmployeeRestDTO>> getEmployeeByLastNameAndFirstName(String lastName, String firstName) {
        if (lastName == null || lastName.isBlank() || firstName == null || lastName.isBlank()) {
            throw CompanyManagementException.badRequest("FieldMissing", "Required field is missing");
        }
        return ResponseEntity.ok(employeeService.getEmployeeByLastNameAndFirstName(lastName, firstName));
    }

    @Override
    public ResponseEntity<List<EmployeeRestDTO>> getEmployeeByLastNameOrFirstName(String lastName, String firstName) {
        if (lastName == null || lastName.isBlank()) {
            throw CompanyManagementException.badRequest("LastNameMissing", "Last name is missing");
        }
        if (firstName == null || firstName.isBlank()) {
            throw CompanyManagementException.badRequest("FirstNameMissing", "First name is missing");
        }
        return ResponseEntity.ok(employeeService.getEmployeeByLastNameOrFirstName(lastName, firstName));
    }

    @Override
    public ResponseEntity<List<EmployeeRestDTO>> getEmployeeByFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw CompanyManagementException.badRequest("FirstNameMissing", "First name is missing");
        }
        return ResponseEntity.ok(employeeService.getEmployeeByFirstName(firstName));
    }

    @Override
    public ResponseEntity<List<EmployeeRestDTO>> getEmployeeBySalaryLessThan(String salary) {
        boolean valid = true;
        Integer salaryInt = 0;
        if (salary == null || salary.trim().isBlank() || salary.isEmpty()) {
            valid = false;
        } else {
            try{
                salaryInt = Integer.parseInt(salary);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(employeeService.getEmployeeBySalaryLessThan(salaryInt));
        } else {
            throw CompanyManagementException.badRequest("InvalidSalaryInput", "Invalid salary input!");
        }
    }

    @Override
    public ResponseEntity<List<EmployeeRestDTO>> getEmployeeBySalaryGreaterThan(String salary) {
        boolean valid = true;
        Integer salaryInt = 0;
        if (salary == null || salary.trim().isBlank() || salary.isEmpty()) {
            valid = false;
        } else {
            try{
                salaryInt = Integer.parseInt(salary);
            } catch (Exception e) {
                valid = false;
            }
        }

        if (valid) {
            return ResponseEntity.ok(employeeService.getEmployeeBySalaryGreaterThan(salaryInt));
        } else {
            throw CompanyManagementException.badRequest("InvalidSalaryInput", "Invalid salary input!");
        }
    }

    //Department
    @Override
    public ResponseEntity<List<DepartmentRestDTO>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @Override
    public ResponseEntity<List<EmployeeRestDTO>> getEmployeesByDeptId(Long deptId) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartmentId(deptId));
    }

    //Location
    @Override
    public ResponseEntity<List<LocationRestDTO>> getAllLocation() {
        return ResponseEntity.ok(locationService.getAllLocation());
    }

    @Override
    public ResponseEntity<List<LocationRestDTO>> getLocationByLocationLike(String location) {
        return ResponseEntity.ok(locationService.getLocationByLocationLike(location));
    }

    @Override
    public ResponseEntity<List<LocationRestDTO>> getLocationByLocationNotLike(String location) {
        return ResponseEntity.ok(locationService.getLocationByLocationNotLike(location));
    }

    @Override
    public ResponseEntity<List<LocationRestDTO>> getLocationByLocationStartingWith(String location) {
        return ResponseEntity.ok(locationService.getLocationByLocationStartingWith(location));
    }

    @Override
    public ResponseEntity<List<LocationRestDTO>> getLocationByLocationEndingWith(String location) {
        return ResponseEntity.ok(locationService.getLocationByLocationEndingWith(location));
    }

    @Override
    public ResponseEntity<List<LocationRestDTO>> getLocationByLocationContaining(String location) {
        return ResponseEntity.ok(locationService.getLocationByLocationContaining(location));
    }

    //Project
    @Override
    public ResponseEntity<List<ProjectRestDTO>> getAllProject() {
        return ResponseEntity.ok(projectService.getAllProject());
    }

    @Override
    public ResponseEntity<List<ProjectRestDTO>> getProjectByProjectNameNot(String name) {
        return ResponseEntity.ok(projectService.getProjectByProjectNameNot(name));
    }

    @Override
    public ResponseEntity<List<ProjectRestDTO>> getProjectByAreaIsNull() {
        return ResponseEntity.ok(projectService.getProjectByAreaNull());
    }

    @Override
    public ResponseEntity<List<ProjectRestDTO>> getProjectByAreaIgnoreCase(String area, Long deptId) {
        return ResponseEntity.ok(projectService.getProjectByAreaIgnoreCase(area, deptId));
    }

    @Override
    public ResponseEntity<List<ProjectRestDTO>> getProjectByAreaNotNull() {
        return ResponseEntity.ok(projectService.getProjectByAreaNotNull());
    }

    @Override
    public ResponseEntity<List<ProjectRestDTO>> getAllProjectOrderByName() {
        return ResponseEntity.ok(projectService.getAllOrderByProjectName());
    }

    //Relative
    @Override
    public ResponseEntity<List<RelativesRestDTO>> getAllRelative() {
        return ResponseEntity.ok(relativesService.getAllRelatives());
    }

    @Override
    public ResponseEntity<List<RelativesRestDTO>> getAllRelativesOrderByFullName() {
        return ResponseEntity.ok(relativesService.getAllRelativesByOrderByFullNameAsc());
    }

    @Override
    public ResponseEntity<List<RelativesRestDTO>> getRelativesByFullNameStartingWith(String string) {
        return ResponseEntity.ok(relativesService.getRelativesByFullNameStartingWith(string));
    }

    @Override
    public ResponseEntity<List<RelativesRestDTO>> getRelativesByFullNameEndingWith(String string) {
        return ResponseEntity.ok(relativesService.getRelativesByFullNameEndingWith(string));

    }

    @Override
    public ResponseEntity<List<RelativesRestDTO>> getRelativesByPhoneNumberContaining(String string) {
        return ResponseEntity.ok(relativesService.getRelativesByPhoneNumberContaining(string));
    }

    @Override
    public ResponseEntity<List<RelativesRestDTO>> getRelativesByRelationshipEquals(String string) {
        return ResponseEntity.ok(relativesService.getRelativesByRelationshipEquals(string));
    }

    @Override
    public ResponseEntity<List<RelativesRestDTO>> getRelativesByEmployeeId(Long employeeId) {
        return ResponseEntity.ok(relativesService.getRelativesByEmployeeId(employeeId));
    }

    //Assignment
    @Override
    public ResponseEntity<List<AssignmentRestDTO>> getAllAssignment() {
        return ResponseEntity.ok(assignmentService.getAllAssignment());
    }

    @Override
    public ResponseEntity<List<AssignmentRestDTO>> getAssignmentByNumberOfHourLessThan(String hours) {
        boolean valid = true;
        Integer hoursInt = 0;
        if (hours == null || hours.trim().isBlank() || hours.isEmpty()) {
            valid = false;
        } else {
            try {
                hoursInt = Integer.parseInt(hours);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid)
            return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourLessThan(hoursInt));
        else {
            throw CompanyManagementException.badRequest("InvalidHoursInput", "Invalid hours.");
        }
    }

    @Override
    public ResponseEntity<List<AssignmentRestDTO>> getAssignmentByNumberOfHourLessThanEqual(String hours) {
        boolean valid = true;
        Integer hoursInt = 0;
        if (hours == null || hours.trim().isBlank() || hours.isEmpty()) {
            valid = false;
        } else {
            try{
                hoursInt = Integer.parseInt(hours);
            } catch (Exception e) {
                valid = false;
            }
        }

        if (valid) {
            return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourLessThanEqual(hoursInt));
        } else {
            throw CompanyManagementException.badRequest("InvalidHoursInput", "Invalid hours input!");
        }
    }

    @Override
    public ResponseEntity<List<AssignmentRestDTO>> getAssignmentByNumberOfHourGreaterThan(String hours) {
        boolean valid = true;
        Integer hoursInt = 0;
        if (hours == null || hours.trim().isBlank() || hours.isEmpty()) {
            valid = false;
        } else {
            try{
                hoursInt = Integer.parseInt(hours);
            } catch (Exception e) {
                valid = false;
            }
        }

        if (valid) {
            return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourGreaterThan(hoursInt));
        } else {
            throw CompanyManagementException.badRequest("InvalidHoursInput", "Invalid hours input!");
        }
    }

    @Override
    public ResponseEntity<List<AssignmentRestDTO>> getAssignmentByNumberOfHourGreaterThanEqual(String hours) {
        boolean valid = true;
        Integer hoursInt = 0;
        if (hours == null || hours.trim().isBlank() || hours.isEmpty()) {
            valid = false;
        } else {
            try{
                hoursInt = Integer.parseInt(hours);
            } catch (Exception e) {
                valid = false;
            }
        }

        if (valid) {
            return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourGreaterThanEqual(hoursInt));
        } else {
            throw CompanyManagementException.badRequest("InvalidHoursInput", "Invalid hours input!");
        }
    }

    @Override
    public ResponseEntity<List<AssignmentRestDTO>> getAssignmentByNumberOfHourBetween(String hour1, String hour2) {
        boolean valid = true;
        Integer hourInt1 = 0;
        Integer hourInt2 = 0;

        if (hour1 == null || hour1.trim().isBlank() || hour1.isEmpty() || hour2 == null || hour2.trim().isBlank() || hour2.isEmpty()) {
            valid = false;
        } else {
            try{
                hourInt1 = Integer.parseInt(hour1);
                hourInt2 = Integer.parseInt(hour2);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourBetween(hourInt1, hourInt2));
        } else {
            throw CompanyManagementException.badRequest("InvalidHoursInput", "Invalid hours input!");
        }
    }

    @Override
    public ResponseEntity<List<AssignmentRestDTO>> getByEmployeeId(Long employeeId) {
        return ResponseEntity.ok(assignmentService.getByEmployeeId(employeeId));
    }
}
