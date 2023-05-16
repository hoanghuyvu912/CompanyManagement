package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.service.dto.*;
import com.example.demo.service.dtoForJava8.*;
import com.example.demo.service.mapper.DepartmentMapper;
import com.example.demo.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@RequiredArgsConstructor
public class Java8Test {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RelativesService relativesService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void getAllEmployeeThatHaveBirthMonthSameWithInputMonth_2() {
        int inputMonth = 4;
        List<EmployeeRestDTO> tempEList = employeeService.getAllEmployee().stream()
                .filter(e -> e.getDateOfBirth().getMonth().getValue() == inputMonth)
                .collect(Collectors.toList());
        tempEList.forEach(System.out::println);
    }

    @Test
    void getEmployeeWithAllRelatives_3() {
        List<EmployeeRestDTO> tempEmployeeList = employeeService.getAllEmployee();
        List<RelativesRestDTO> tempRelativesList = relativesService.getAllRelatives();
        List<EmployeeWithRelativesDto> employeeWithRelativesDtos = new ArrayList<>();

        for (int i = 0; i < tempEmployeeList.size(); i++) {
            int finalI = i;
            EmployeeWithRelativesDto tempEmp = new EmployeeWithRelativesDto();
            tempEmp.setEmployee(tempEmployeeList.get(i));
            List<RelativesRestDTO> tempRelativesOfEmp = tempRelativesList.stream()
                    .filter(r -> r.getEmployee().getId() == tempEmployeeList.get(finalI).getId())
                    .collect(Collectors.toList());
            tempEmp.setRelativesRestDTOS(tempRelativesOfEmp);
            employeeWithRelativesDtos.add(tempEmp);
        }
        employeeWithRelativesDtos.forEach(System.out::println);
    }

    @Test
    void getDepartmentWithManagedProject_5() {
        List<DepartmentRestDTO> tempDepartmentList = departmentService.getAllDepartment();
        List<ProjectRestDTO> tempProjectList = projectService.getAllProject();
        List<DepartmentWithManagedProjectsDto> deptWithProjectList = new ArrayList<>();

        for (int i = 0; i < tempDepartmentList.size(); i++) {
            int finalI = i;
            DepartmentWithManagedProjectsDto tempDept = new DepartmentWithManagedProjectsDto();
            tempDept.setDepartmentRestDTO(tempDepartmentList.get(i));
            List<ProjectRestDTO> tempProjectOfDept = tempProjectList.stream()
                    .filter(p -> p.getDepartment().getId() == tempDepartmentList.get(finalI).getId())
                    .collect(Collectors.toList());
            tempDept.setProjectRestDTOS(tempProjectOfDept);
            deptWithProjectList.add(tempDept);
        }
        deptWithProjectList.forEach(System.out::println);
    }

    @Test
    void getProjectWithEmpNumHourNum_6() {
        String location = "Sai Gon";
        List<ProjectRestDTO> tempProjectList = projectService.getAllProject();
        List<AssignmentRestDTO> tempAssignmentList = assignmentService.getAllAssignment();
        List<ProjectRestDTO> tempProjectWithMatchedLocation = tempProjectList.stream()
                .filter(p -> location.equalsIgnoreCase(p.getArea()))
                .collect(Collectors.toList());
        tempProjectWithMatchedLocation.forEach(System.out::println);

        List<ProjectWithTotalEmpTotalHourDto> projectWithTotalEmpTotalHourDtoList = new ArrayList<>();

//        List<ProjectWithTotalEmpTotalHourDto> projectWithTotalEmpTotalHourDtoList = tempAssignmentList.stream()
//                    .filter(a -> a.getId() == tempProjectWithMatchedLocation.get(finalI).getId())

        for (int i = 0; i < tempProjectWithMatchedLocation.size(); i++) {
            ProjectWithTotalEmpTotalHourDto tempProject = new ProjectWithTotalEmpTotalHourDto();
            int finalI = i;
            int numberOfHour = tempAssignmentList.stream()
                    .filter(a -> a.getProject().getId() == tempProjectWithMatchedLocation.get(finalI).getId()).map(AssignmentRestDTO::getNumberOfHour)
                    .reduce(0, Integer::sum);
            long count = tempAssignmentList.stream().filter(a -> tempProjectWithMatchedLocation.get(finalI).getId() == a.getProject().getId()).map(AssignmentRestDTO::getEmployee).count();

            tempProject.setNumberOfHours(numberOfHour);
            tempProject.setNumberOfEmployees((int) count);
            projectWithTotalEmpTotalHourDtoList.add(tempProject);
        }
        projectWithTotalEmpTotalHourDtoList.forEach(System.out::println);
    }

    @Test
    void getProjectWithTotalHoursTotalSalary_7() {
        String location = "Sai Gon";
//        List<ProjectRestDTO> tempProjectList = projectService.getAllProject();
        List<AssignmentRestDTO> tempAssignmentList = assignmentService.getAllAssignment();
        int totalHours = tempAssignmentList.stream().filter(p -> location.equalsIgnoreCase(p.getProject().getArea())).map(AssignmentRestDTO::getNumberOfHour).reduce(0, Integer::sum);
        double totalSalary = tempAssignmentList.stream().filter(p -> location.equalsIgnoreCase(p.getProject().getArea())).map(AssignmentRestDTO::getEmployee).map(Employee::getSalary).reduce(0, Integer::sum);
        ProjectWithTotalHoursTotalSalaryDto projectWithTotalHoursTotalSalaryDto = new ProjectWithTotalHoursTotalSalaryDto(totalHours, totalSalary);
        System.out.println(projectWithTotalHoursTotalSalaryDto);
    }

    @Test
    void getProjectWithManagedDepartmentName_8() {
        List<ProjectRestDTO> tempProjectList = projectService.getAllProject();
        List<ProjectWithManagedDepartmentNameDto> projectWithManagedDepartmentNameDtos = tempProjectList.stream()
                .map(p -> new ProjectWithManagedDepartmentNameDto(p, p.getDepartment().getName()))
                .collect(Collectors.toList());
        projectWithManagedDepartmentNameDtos.forEach(System.out::println);
    }

    @Test
    void getAllDepartmentWithProject_9() {
        List<ProjectRestDTO> tempProjectList = projectService.getAllProject();
        List<DepartmentWithProjectDto> departmentWithProjectDtos = tempProjectList.stream()
                .map(p -> new DepartmentWithProjectDto(departmentMapper.toRestDTO(p.getDepartment()), p))
                .collect(Collectors.toList());
        departmentWithProjectDtos.forEach(System.out::println);
    }

    @Test
    void getProjectWithEmpNumHourNumInASpecificArea_10() {
        //giống câu 6
        String location = "Trang Bom";
        List<ProjectRestDTO> tempProjectList = projectService.getAllProject();
        List<AssignmentRestDTO> tempAssignmentList = assignmentService.getAllAssignment();
        List<ProjectRestDTO> tempProjectWithMatchedLocation = tempProjectList.stream()
                .filter(p -> location.equalsIgnoreCase(p.getArea()))
                .collect(Collectors.toList());
        tempProjectWithMatchedLocation.forEach(System.out::println);

        List<ProjectWithTotalEmpTotalHourDto> projectWithTotalEmpTotalHourDtoList = new ArrayList<>();
        for (int i = 0; i < tempProjectWithMatchedLocation.size(); i++) {
            ProjectWithTotalEmpTotalHourDto tempProject = new ProjectWithTotalEmpTotalHourDto();
            int finalI = i;
            int numberOfHour = tempAssignmentList.stream()
                    .filter(a -> a.getProject().getId() == tempProjectWithMatchedLocation.get(finalI).getId()).map(AssignmentRestDTO::getNumberOfHour)
                    .reduce(0, Integer::sum);
            long count = tempAssignmentList.stream().filter(a -> tempProjectWithMatchedLocation.get(finalI).getId() == a.getProject().getId()).map(AssignmentRestDTO::getEmployee).count();

            tempProject.setNumberOfHours(numberOfHour);
            tempProject.setNumberOfEmployees((int) count);
            projectWithTotalEmpTotalHourDtoList.add(tempProject);
        }
        projectWithTotalEmpTotalHourDtoList.forEach(System.out::println);
    }

    @Test
    void getUnassignedEmployees_12() {
        List<AssignmentRestDTO> tempAssignmentList = assignmentService.getAllAssignment();
        List<EmployeeRestDTO> tempEmployeeList = employeeService.getAllEmployee();

        List<EmployeeRestDTO> unAssignedEmployeesList = tempEmployeeList.stream()
                .filter(e -> !(tempAssignmentList.stream().map(AssignmentRestDTO::getEmployee).map(Employee::getId).collect(Collectors.toList())).contains(e.getId()))
                .collect(Collectors.toList());
        unAssignedEmployeesList.forEach(System.out::println);
    }

    @Test
    void getEmployeeWorkOnProjectManagedByAnotherDept() {
        List<AssignmentRestDTO> tempAssignmentList = assignmentService.getAllAssignment();
        List<EmployeeRestDTO> tempEmployeeList = employeeService.getAllEmployee();
        List<EmployeeRestDTO> employeeWorkOnProjectManagedByAnotherDept = tempEmployeeList.stream()
                .filter(e -> !(tempAssignmentList.stream().map(AssignmentRestDTO::getProject).map(Project::getDepartment).map(Department::getId).collect(Collectors.toList())).contains(e.getDepartment().getId()))
                .collect(Collectors.toList());
        employeeWorkOnProjectManagedByAnotherDept.forEach(System.out::println);
    }
}
