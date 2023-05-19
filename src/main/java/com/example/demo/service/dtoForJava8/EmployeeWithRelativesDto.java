package com.example.demo.service.dtoForJava8;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.EmployeeRestDTO;
import com.example.demo.service.dto.RelativesRestDTO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeWithRelativesDto {
    private EmployeeRestDTO employee;
    private List<RelativeJava8Dto> relativeJava8Dtos;

    public EmployeeWithRelativesDto() {
        this(null, null);
    }

    public EmployeeWithRelativesDto(EmployeeRestDTO employee, List<RelativeJava8Dto> relativeJava8Dtos) {
        this.employee = employee;
        this.relativeJava8Dtos = relativeJava8Dtos;
    }

    public EmployeeRestDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeRestDTO employee) {
        this.employee = employee;
    }

    public List<RelativeJava8Dto> getRelativeJava8Dtos() {
        return relativeJava8Dtos;
    }

    public void setRelativesRestDTOS(List<RelativeJava8Dto> relativeJava8Dtos) {
        this.relativeJava8Dtos  = new ArrayList<>(relativeJava8Dtos);
    }

    @Override
    public String toString() {
        return "EmployeeWithRelativesDto: " +
                "\nEmployee: " + employee +
                "\nRelatives: " + relativeJava8Dtos + "\n";
    }
}
