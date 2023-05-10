package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Project;
import com.example.demo.exception.CompanyManagementException;
import com.example.demo.respository.DepartmentRepository;
import com.example.demo.respository.ProjectRepository;
import com.example.demo.service.dto.ProjectDTO;
import com.example.demo.service.dto.ProjectRestDTO;
import com.example.demo.service.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final DepartmentRepository departmentRepository;
    private final ProjectMapper projectMapper;

    public List<ProjectRestDTO> getAllProject() {
        return projectMapper.toRestDTOs(projectRepository.findAll());
    }

    public ProjectRestDTO getProjectById(Long projectId, Long deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(CompanyManagementException::DepartmentNotFound);
        Project project = projectRepository.findById(projectId).orElseThrow(CompanyManagementException::ProjectNotFound);
        return projectMapper.toRestDTO(project);
    }

    public List<ProjectRestDTO> getAllOrderByProjectName() {
        return projectMapper.toRestDTOs(projectRepository.findAllProjectByOrderByProjectName());
    }

    public List<ProjectRestDTO> getProjectByAreaIgnoreCase(String area, Long deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(CompanyManagementException::DepartmentNotFound);
        if (area == null || area.trim().isBlank() || area.isEmpty()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search string is missing.");
        }
        List<Project> list = projectRepository.findByAreaIgnoreCase(area);
        return projectMapper.toRestDTOs(list);
    }

    public ProjectRestDTO createProject(ProjectDTO projectDTO, Long deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(CompanyManagementException::DepartmentNotFound);
        Project project = new Project();
        project.setArea(projectDTO.getArea());
        project.setProjectName(projectDTO.getProjectName());
        project.setDepartment(department);
        return projectMapper.toRestDTO(projectRepository.save(project));
    }

    public List<ProjectRestDTO> getProjectByProjectNameNot(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search string is missing.");
        }
        return projectMapper.toRestDTOs(projectRepository.findByProjectNameNot(s));
    }

    public List<ProjectRestDTO> getProjectByAreaNull() {
        return projectMapper.toRestDTOs(projectRepository.findByAreaIsNull());
    }

    public List<ProjectRestDTO> getProjectByAreaNotNull() {
        return projectMapper.toRestDTOs(projectRepository.findByAreaNotNull());
    }

    public ProjectRestDTO updateProject(ProjectDTO projectDTO, Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(CompanyManagementException::ProjectNotFound);
        project.setArea(projectDTO.getArea());
        project.setProjectName(projectDTO.getProjectName());
        return projectMapper.toRestDTO(projectRepository.save(project));
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
