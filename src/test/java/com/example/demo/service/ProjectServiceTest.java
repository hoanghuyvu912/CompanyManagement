package com.example.demo.service;

import com.example.demo.service.dto.ProjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {
    @Autowired
    ProjectService projectService;

    @Test
    void getAllProject() {
        System.out.println(projectService.getAllProject());
    }

    @Test
    void createProject(ProjectDTO projectDTO, Long deptId) {
        System.out.println(projectService.createProject(projectDTO, deptId));
    }
}