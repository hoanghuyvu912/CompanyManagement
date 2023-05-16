package com.example.demo.service.dtoForJava8;

import com.example.demo.service.dto.DepartmentRestDTO;
import com.example.demo.service.dto.ProjectRestDTO;

public class DepartmentWithProjectDto {
    private DepartmentRestDTO departmentRestDTO;
    private ProjectRestDTO projectRestDTO;

    public DepartmentWithProjectDto() {
        this(null, null);
    }

    public DepartmentWithProjectDto(DepartmentRestDTO departmentRestDTO, ProjectRestDTO projectRestDTO) {
        this.departmentRestDTO = departmentRestDTO;
        this.projectRestDTO = projectRestDTO;
    }

    public DepartmentRestDTO getDepartmentRestDTO() {
        return departmentRestDTO;
    }

    public void setDepartmentRestDTO(DepartmentRestDTO departmentRestDTO) {
        this.departmentRestDTO = departmentRestDTO;
    }

    public ProjectRestDTO getProjectRestDTO() {
        return projectRestDTO;
    }

    public void setProjectRestDTO(ProjectRestDTO projectRestDTO) {
        this.projectRestDTO = projectRestDTO;
    }

    @Override
    public String toString() {
        return
                "Department: " + departmentRestDTO.getName() +
                        "\nProject: " + projectRestDTO.getProjectName() + "\n\n";
    }
}
