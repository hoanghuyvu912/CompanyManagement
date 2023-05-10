package com.example.demo.service.mapper;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.EmployeeDTO;
import com.example.demo.service.dto.EmployeeRestDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employee);

    EmployeeRestDTO toRestDTO(Employee employee);

    List<EmployeeDTO> toDTOs(List<Employee> employees);

    List<EmployeeRestDTO> toRestDTOs(List<Employee> employees);

}
