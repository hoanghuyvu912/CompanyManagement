package com.example.demo.service.dtoForJava8;

import com.example.demo.service.dto.ProjectRestDTO;

public class ProjectWithManagedDepartmentNameDto {
    private ProjectRestDTO projectRestDTO;
    private String departmentName;

    public ProjectWithManagedDepartmentNameDto() {
        this(null, null);
    }

    public ProjectWithManagedDepartmentNameDto(ProjectRestDTO projectRestDTO, String departmentName) {
        this.projectRestDTO = projectRestDTO;
        this.departmentName = departmentName;
    }

    public ProjectRestDTO getProjectRestDTO() {
        return projectRestDTO;
    }

    public void setProjectRestDTO(ProjectRestDTO projectRestDTO) {
        this.projectRestDTO = projectRestDTO;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Project: " + projectRestDTO +
                "\nDepartment Name: " + departmentName + "\n";
    }
}
