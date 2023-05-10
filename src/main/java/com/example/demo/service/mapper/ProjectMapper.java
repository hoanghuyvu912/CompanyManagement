package com.example.demo.service.mapper;

import com.example.demo.entity.Project;
import com.example.demo.service.dto.ProjectDTO;
import com.example.demo.service.dto.ProjectRestDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDTO toDTO(Project project);

    ProjectRestDTO toRestDTO(Project project);

    List<ProjectDTO> toDTOs(List<Project> projects);

    List<ProjectRestDTO> toRestDTOs(List<Project> projects);
}
