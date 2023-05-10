package com.example.demo.service.mapper;

import com.example.demo.entity.Department;
import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.dto.DepartmentRestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDTO toDTO(Department department);

    DepartmentRestDTO toRestDTO(Department department);

    List<DepartmentDTO> toDTOs(List<Department> departments);

    List<DepartmentRestDTO> toRestDTOs(List<Department> department);

}
