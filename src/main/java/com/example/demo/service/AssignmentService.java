package com.example.demo.service;

import com.example.demo.entity.Assignment;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.exception.CompanyManagementException;
import com.example.demo.respository.AssignmentRepository;
import com.example.demo.respository.DepartmentRepository;
import com.example.demo.respository.EmployeeRepository;
import com.example.demo.respository.ProjectRepository;
import com.example.demo.service.dto.AssignmentDTO;
import com.example.demo.service.dto.AssignmentRestDTO;
import com.example.demo.service.mapper.AssignmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;
    private final AssignmentMapper assignmentMapper;

    public List<AssignmentRestDTO> getAllAssignment() {
        return assignmentMapper.toRestDTOs(assignmentRepository.findAll());
    }

    public AssignmentRestDTO getAssignmentById(Long assignmentId, Long projectId, Long employeeId) {
        Project project = projectRepository.findById(projectId).orElseThrow(CompanyManagementException::ProjectNotFound);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(CompanyManagementException::EmployeeNotFound);
        Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow(CompanyManagementException::AssignmentNotFound);
        return assignmentMapper.toRestDTO(assignment);
    }

    public List<AssignmentRestDTO> getAssignmentByNumberOfHourLessThan(Integer h) {
        if (h <= 0) {
            throw CompanyManagementException.badRequest("InvalidHourInput", "The number of hours must be a positive number.");
        }
        return assignmentMapper.toRestDTOs(assignmentRepository.findByNumberOfHourLessThan(h));
    }

    public List<AssignmentRestDTO> getAssignmentByNumberOfHourLessThanEqual(Integer h) {
        if (h <= 0) {
            throw CompanyManagementException.badRequest("InvalidHourInput", "The number of hours must be a positive number.");
        }
        return assignmentMapper.toRestDTOs(assignmentRepository.findByNumberOfHourLessThanEqual(h));
    }

    public List<AssignmentRestDTO> getAssignmentByNumberOfHourGreaterThan(Integer h) {
        if (h <= 0) {
            throw CompanyManagementException.badRequest("InvalidHourInput", "The number of hours must be a positive number.");
        }
        return assignmentMapper.toRestDTOs(assignmentRepository.findByNumberOfHourGreaterThan(h));
    }

    public List<AssignmentRestDTO> getAssignmentByNumberOfHourGreaterThanEqual(Integer h) {
        if (h <= 0) {
            throw CompanyManagementException.badRequest("InvalidHourInput", "The number of hours must be a positive number.");
        }
        return assignmentMapper.toRestDTOs(assignmentRepository.findByNumberOfHourGreaterThanEqual(h));
    }

    public List<AssignmentRestDTO> getAssignmentByNumberOfHourBetween(Integer h1, Integer h2) {
        if (h1 <= 0 || h2 <= 0) {
            throw CompanyManagementException.badRequest("InvalidHourInput", "The number of hours must be a positive number.");
        }
        return assignmentMapper.toRestDTOs(assignmentRepository.findByNumberOfHourBetween(h1, h2));
    }

    public AssignmentRestDTO createAssignment(AssignmentDTO assignmentDTO, Long deptId, Long employeeId) {
        Project project = projectRepository.findById(deptId).orElseThrow(CompanyManagementException::ProjectNotFound);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(CompanyManagementException::EmployeeNotFound);

        Assignment assignment = new Assignment();

        if (assignmentDTO.getNumberOfHour() <= 0) {
            throw CompanyManagementException.badRequest("InvalidNumberOfHours", "The number of hours must be a positive number.");
        }

        assignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        assignment.setProject(project);
        assignment.setEmployee(employee);
        return assignmentMapper.toRestDTO(assignmentRepository.save(assignment));
    }

    public AssignmentRestDTO updateAssignment(AssignmentDTO assignmentDTO, Long assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow(CompanyManagementException::DepartmentNotFound);
        if (assignmentDTO.getNumberOfHour() <= 0) {
            throw CompanyManagementException.badRequest("InvalidNumberOfHours", "The number of hours must be a positive number.");
        }
        assignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        return assignmentMapper.toRestDTO(assignmentRepository.save(assignment));
    }

    public void deleteAssignment(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }
}
