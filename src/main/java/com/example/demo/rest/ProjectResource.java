package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import com.example.demo.service.dto.EmployeeDTO;
import com.example.demo.service.dto.ProjectDTO;
import com.example.demo.service.dto.ProjectRestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProjectResource implements ProjectAPI {
    private final ProjectService projectService;

    @Override
    public ResponseEntity<ProjectRestDTO> getProjectById(Long projectId, Long deptId) {
        ProjectRestDTO projectRestDTO = projectService.getProjectById(projectId, deptId);
        return ResponseEntity.ok(projectRestDTO);
    }

    @Override
    public ResponseEntity<ProjectRestDTO> createProject(ProjectDTO projectDTO, Long deptId) {
        ProjectRestDTO projectRestDTO = projectService.createProject(projectDTO, deptId);
        return ResponseEntity.created(URI.create("/api/departments" + deptId + "/projects/" + projectRestDTO.getId())).body(projectRestDTO);
    }


    @Override
    public ResponseEntity<ProjectRestDTO> updateProject(ProjectDTO projectDTO, Long projectId) {
        ProjectRestDTO projectRestDTO = projectService.updateProject(projectDTO, projectId);
        return ResponseEntity.ok().body(projectRestDTO);
    }

    @Override
    public ResponseEntity<Void> deleteProject(Long projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
