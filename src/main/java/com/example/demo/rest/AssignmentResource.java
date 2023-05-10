package com.example.demo.rest;

import com.example.demo.entity.Assignment;
import com.example.demo.service.AssignmentService;
import com.example.demo.service.dto.AssignmentDTO;
import com.example.demo.service.dto.AssignmentRestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AssignmentResource implements AssignmentAPI {
    private final AssignmentService assignmentService;

    @Override
    public ResponseEntity<AssignmentRestDTO> getAssignmentById(Long assignmentId, Long projectId, Long employeeId) {
//        Optional<Assignment> optionalAssignment = assignmentService.getAssignmentById(assignmentId, projectId, employeeId);
//        return ResponseEntity.ok(optionalAssignment.get());
        return ResponseEntity.ok(assignmentService.getAssignmentById(assignmentId, projectId, employeeId));
    }

    @Override
    public ResponseEntity<AssignmentRestDTO> createAssignment(AssignmentDTO assignmentDTO, Long projectId, Long employeeId) {
        AssignmentRestDTO assignmentRestDTO = assignmentService.createAssignment(assignmentDTO, projectId, employeeId);
        return ResponseEntity.created(URI.create("/api/projects/" + projectId + "/employees/" + employeeId + "/" + assignmentRestDTO.getId())).body(assignmentRestDTO);
    }


    @Override
    public ResponseEntity<AssignmentRestDTO> updateAssignment(AssignmentDTO assignmentDTO, Long assignmentId) {
        AssignmentRestDTO assignmentRestDTO = assignmentService.updateAssignment(assignmentDTO, assignmentId);
        return ResponseEntity.ok().body(assignmentRestDTO);
    }

    @Override
    public ResponseEntity<Void> deleteAssignment(Long assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
        return ResponseEntity.noContent().build();
    }
}
