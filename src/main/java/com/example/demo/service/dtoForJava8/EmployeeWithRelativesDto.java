package com.example.demo.service.dtoForJava8;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.EmployeeRestDTO;
import com.example.demo.service.dto.RelativesRestDTO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeWithRelativesDto {
    private EmployeeRestDTO employee;
    private List<RelativesRestDTO> relativesRestDTOS;

    public EmployeeWithRelativesDto() {
        this(null, null);
    }

    public EmployeeWithRelativesDto(EmployeeRestDTO employee, List<RelativesRestDTO> relativesRestDTOS) {
        this.employee = employee;
        this.relativesRestDTOS = relativesRestDTOS;
    }

    public EmployeeRestDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeRestDTO employee) {
        this.employee = employee;
    }

    public List<RelativesRestDTO> getRelativesRestDTOS() {
        return relativesRestDTOS;
    }

    public void setRelativesRestDTOS(List<RelativesRestDTO> relativesRestDTOS) {
        this.relativesRestDTOS = new ArrayList<>(relativesRestDTOS);
    }

    @Override
    public String toString() {
        return "EmployeeWithRelativesDto: " +
                "\nEmployee: " + employee +
                "\nRelatives: " + relativesRestDTOS + "\n";
    }
}
