package com.example.demo.rest;

import com.example.demo.entity.Assignment;
import com.example.demo.service.dto.AssignmentDTO;
import com.example.demo.service.dto.AssignmentRestDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/projects/{projectId}/employees/{employeeId}/assignments")
public interface AssignmentAPI {
    @GetMapping(value = "/{assignmentId}")
    ResponseEntity<AssignmentRestDTO> getAssignmentById(@PathVariable Long assignmentId, @PathVariable Long projectId, @PathVariable Long employeeId);

    @PostMapping
    ResponseEntity<Assignment> createAssignment(@RequestBody AssignmentDTO assignmentDTO, @PathVariable Long employeeId, @PathVariable Long projectId);

    @PutMapping(value = "/{assignmentId}")
    ResponseEntity<Assignment> updateAssignment(@RequestBody AssignmentDTO assignmentDTO, @PathVariable Long assignmentId);

    @DeleteMapping(value = "/{assignmentId}")
    ResponseEntity<Void> deleteAssignment(@PathVariable Long assignmentId);
}
