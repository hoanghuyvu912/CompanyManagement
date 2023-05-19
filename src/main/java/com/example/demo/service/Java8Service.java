package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.*;
import com.example.demo.service.dtoForJava8.DepartmentWithManagedProjectsDto;
import com.example.demo.service.dtoForJava8.EmployeeWithRelativesDto;
import com.example.demo.service.dtoForJava8.ProjectWithTotalEmpTotalHourDto;
import com.example.demo.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Java8Service {
    private EmployeeService employeeService;


    private DepartmentService departmentService;


    private RelativesService relativesService;


    private ProjectService projectService;


    private LocationService locationService;

    private AssignmentService assignmentService;

    private EmployeeMapper employeeMapper;

    void getAllEmployeeThatHaveBirthMonthSameWithInputMonth() {
        int inputMonth = 4;
        List<EmployeeRestDTO> tempEList = employeeService.getAllEmployee().stream().filter(e -> e.getDateOfBirth().getMonth().getValue() == inputMonth).collect(Collectors.toList());
        tempEList.forEach(System.out::println);
    }

//    void getEmployeeWithAllRelatives() {
//        List<EmployeeRestDTO> templEmployeeList = employeeService.getAllEmployee();
//        List<RelativesRestDTO> tempRelativesList = relativesService.getAllRelatives();
//        List<EmployeeWithRelativesDto> employeeWithRelativesDtos = new ArrayList<>();
//
//        for (int i = 0; i < templEmployeeList.size(); i++) {
//            int finalI = i;
//            EmployeeWithRelativesDto tempEmp = new EmployeeWithRelativesDto();
//            tempEmp.setEmployee(templEmployeeList.get(i));
//            List<RelativesRestDTO> tempRelativesOfEmp = tempRelativesList.stream().filter(r -> r.getEmployee().getId() == templEmployeeList.get(finalI).getId()).collect(Collectors.toList());
//            tempEmp.setRelativesRestDTOS(tempRelativesOfEmp);
//            employeeWithRelativesDtos.add(tempEmp);
//        }
//        employeeWithRelativesDtos.forEach(System.out::println);
//    }

    void getDepartmentWithManagedProject() {
        List<DepartmentRestDTO> tempDepartmentList = departmentService.getAllDepartment();
        List<ProjectRestDTO> tempProjectList = projectService.getAllProject();
        List<DepartmentWithManagedProjectsDto> deptWithProjectList = new ArrayList<>();

        for (int i = 0; i < tempDepartmentList.size(); i++) {
            int finalI = i;
            DepartmentWithManagedProjectsDto tempDept = new DepartmentWithManagedProjectsDto();
            tempDept.setDepartmentRestDTO(tempDepartmentList.get(i));
            List<ProjectRestDTO> tempProjectOfDept = tempProjectList.stream().filter(p -> p.getDepartment().getId() == tempDepartmentList.get(finalI).getId()).collect(Collectors.toList());
            tempDept.setProjectRestDTOS(tempProjectOfDept);
            deptWithProjectList.add(tempDept);
        }
        deptWithProjectList.forEach(System.out::println);
    }

    void getProjectWithEmpNumHourNum() {
        String location = "Sai Gon";
        List<ProjectRestDTO> tempProjectList = projectService.getAllProject();
        List<AssignmentRestDTO> tempAssignmentList = assignmentService.getAllAssignment();
//        tempProjectList.forEach(p -> System.out.println(p.getArea()));
        List<ProjectRestDTO> tempProjectWithMatchedLocation = tempProjectList.stream().filter(p -> location.equalsIgnoreCase(p.getArea())).collect(Collectors.toList());
        List<ProjectWithTotalEmpTotalHourDto> projectWithTotalEmpTotalHourDtoList = new ArrayList<>();

        for (int i = 0; i < tempProjectWithMatchedLocation.size(); i++) {
            ProjectWithTotalEmpTotalHourDto tempProject = new ProjectWithTotalEmpTotalHourDto();
            int finalI = i;
            int numberOfHour = tempAssignmentList.stream().filter(a -> a.getId() == tempProjectWithMatchedLocation.get(finalI).getId()).map(AssignmentRestDTO::getNumberOfHour).reduce(0, Integer::sum);
            List<Employee> tempEmpList = tempAssignmentList.stream().filter(a -> a.getId() == tempProjectWithMatchedLocation.get(finalI).getId()).map(AssignmentRestDTO::getEmployee).collect(Collectors.toList());
            tempProject.setNumberOfHours(numberOfHour);
            tempProject.setNumberOfEmployees(tempEmpList.size());
            projectWithTotalEmpTotalHourDtoList.add(tempProject);
        }
        projectWithTotalEmpTotalHourDtoList.forEach(System.out::println);
    }
}
