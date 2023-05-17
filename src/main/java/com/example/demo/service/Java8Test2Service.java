package com.example.demo.service;

import com.example.demo.service.dto.DepartmentRestDTO;
import com.example.demo.service.dto.ProjectRestDTO;
import com.example.demo.service.dtoForJava8.DepartmentWithManagedProjectsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Test2Service {
//    public List<> getDepartmentWithManagedProject_5() {
//        List<DepartmentRestDTO> tempDepartmentList = departmentService.getAllDepartment();
//        List<ProjectRestDTO> tempProjectList = projectService.getAllProject();
//        List<DepartmentWithManagedProjectsDto> deptWithProjectList = new ArrayList<>();
//
//        for (int i = 0; i < tempDepartmentList.size(); i++) {
//            int finalI = i;
//            DepartmentWithManagedProjectsDto tempDept = new DepartmentWithManagedProjectsDto();
//            tempDept.setDepartmentRestDTO(tempDepartmentList.get(i));
//            List<ProjectRestDTO> tempProjectOfDept = tempProjectList.stream()
//                    .filter(p -> p.getDepartment().getId() == tempDepartmentList.get(finalI).getId())
//                    .collect(Collectors.toList());
//            tempDept.setProjectRestDTOS(tempProjectOfDept);
//            deptWithProjectList.add(tempDept);
//        }
//        deptWithProjectList.forEach(System.out::println);
//    }
}
