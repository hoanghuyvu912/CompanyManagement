package com.example.demo.service.dtoForJava8;

import com.example.demo.service.dto.DepartmentRestDTO;
import com.example.demo.service.dto.ProjectRestDTO;

import java.util.ArrayList;
import java.util.List;

public class DepartmentWithManagedProjectsDto {
    private DepartmentRestDTO departmentRestDTO;
    private List<ProjectRestDTO> projectRestDTOS;

    public DepartmentWithManagedProjectsDto() {
        this(null, null);
    }

    public DepartmentWithManagedProjectsDto(DepartmentRestDTO departmentRestDTO, ArrayList<ProjectRestDTO> projectRestDTOS) {
        this. departmentRestDTO =  departmentRestDTO;
        this.projectRestDTOS = projectRestDTOS;
    }

    public DepartmentRestDTO  departmentRestDTO() {
        return  departmentRestDTO;
    }

    public void setDepartmentRestDTO(DepartmentRestDTO departmentRestDTO) {
        this.departmentRestDTO = departmentRestDTO;
    }

    public List<ProjectRestDTO> getProjectRestDTOS() {
        return projectRestDTOS;
    }

    public void setProjectRestDTOS(List<ProjectRestDTO> projectRestDTOS) {
        this.projectRestDTOS = new ArrayList<>(projectRestDTOS);
    }

    @Override
    public String toString() {
        return "Department With Projects: " +
                "Department:" + departmentRestDTO +
                "\nProject list: \n" + projectRestDTOS + "\n";
    }
}
