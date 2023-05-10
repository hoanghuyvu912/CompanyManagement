package com.example.demo.rest;

import com.example.demo.entity.Project;
import com.example.demo.service.dto.ProjectDTO;
import com.example.demo.service.dto.ProjectRestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping(value = "/api/departments/{deptId}/projects")
public interface ProjectAPI {
    @GetMapping(value = "/{projectId}")
    ResponseEntity<ProjectRestDTO> getProjectById(@PathVariable Long projectId, @PathVariable Long deptId);

    @PostMapping
    ResponseEntity<Project> createProject(@RequestBody ProjectDTO projectDTO, @PathVariable("deptId") Long deptId);


    @PutMapping(value = "/{projectId}")
    ResponseEntity<Project> updateProject(@RequestBody ProjectDTO projectDTO, @PathVariable Long projectId);

    @DeleteMapping(value = "/{projectId}")
    ResponseEntity<Void> deleteProject(@PathVariable Long projectId);
}
