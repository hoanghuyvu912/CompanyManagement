package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Project;
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

    public Optional<Project> getProjectById(Long projectId, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Optional<Project> optionalProject = null;
        if (department.isPresent()) {
            optionalProject = projectRepository.findById(projectId);
        }
        return optionalProject;
    }

    public List<ProjectRestDTO> getAllOrderByProjectName() {
        return projectMapper.toRestDTOs(projectRepository.findAllProjectByOrderByProjectName());
    }

    public List<Project> getProjectByAreaIgnoreCase(String area, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        List<Project> list = null;
        if (department.isPresent()) {
            list = projectRepository.findByAreaIgnoreCase(area);
        }
        return list;
    }

    public Project createProject(ProjectDTO projectDTO, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Project project = new Project();
        project.setArea(projectDTO.getArea());
        project.setProjectName(projectDTO.getProjectName());
        if (department.isPresent()) {
            project.setDepartment(department.get());
        }
        return projectRepository.save(project);
    }

    public List<ProjectRestDTO> getProjectByProjectNameNot(String s) {
        return projectMapper.toRestDTOs(projectRepository.findByProjectNameNot(s));
    }

    public List<ProjectRestDTO> getProjectByAreaNull() {
        return projectMapper.toRestDTOs(projectRepository.findByAreaIsNull());
    }

    public List<ProjectRestDTO> getProjectByAreaNotNull() {
        return projectMapper.toRestDTOs(projectRepository.findByAreaNotNull());
    }

    public Project updateProject(ProjectDTO projectDTO, Long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        Project updatedProject = project.get();
        updatedProject.setArea(projectDTO.getArea());
        updatedProject.setProjectName(projectDTO.getProjectName());
        return projectRepository.save(updatedProject);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
