package com.example.demo.service.mapper;

import com.example.demo.entity.Assignment;
import com.example.demo.service.dto.AssignmentDTO;
import com.example.demo.service.dto.AssignmentRestDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    AssignmentDTO toDTO(Assignment assignment);

    AssignmentRestDTO toRestDTO(Assignment assignment);

    List<AssignmentDTO> toDTOs(List<Assignment> assignments);

    List<AssignmentRestDTO> toRestDTOs(List<Assignment> assignments);
}
