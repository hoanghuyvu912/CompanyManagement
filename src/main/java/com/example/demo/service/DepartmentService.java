package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.exception.CompanyManagementException;
import com.example.demo.respository.DepartmentRepository;
import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.dto.DepartmentRestDTO;
import com.example.demo.service.dto.DepartmentWithNumOfEmployeeDTO;
import com.example.demo.service.dto.DepartmentWithNumOfProjectsDTO;
import com.example.demo.service.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    public List<DepartmentRestDTO> getAllDepartment() {
        return departmentMapper.toRestDTOs(departmentRepository.findAll());
    }

    public DepartmentRestDTO getDepartmentById(Long deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(CompanyManagementException::DepartmentNotFound);
        return departmentMapper.toRestDTO(department);
    }

    public List<DepartmentRestDTO> getDepartmentByDate(LocalDate localDate) {
        if (localDate == null) {
            throw CompanyManagementException.badRequest("LocalDateMissing", "Date missing.");
        }
        return departmentMapper.toRestDTOs(departmentRepository.findByStartDate(localDate));
    }

    public List<DepartmentRestDTO> getDepartmentByDateAfter(LocalDate localDate) {
        if (localDate == null) {
            throw CompanyManagementException.badRequest("LocalDateMissing", "Date missing.");
        }
        return departmentMapper.toRestDTOs(departmentRepository.findByStartDateAfter(localDate));
    }

    public List<DepartmentRestDTO> getDepartmentByDateBefore(LocalDate localDate) {
        if (localDate == null) {
            throw CompanyManagementException.badRequest("LocalDateMissing", "Date missing.");
        }
        return departmentMapper.toRestDTOs(departmentRepository.findByStartDateBefore(localDate));
    }

    public List<DepartmentRestDTO> getDepartmentByStartDateBetween(LocalDate beginDate, LocalDate endDate) {
        if (beginDate == null) {
            throw CompanyManagementException.badRequest("FirstDateMissing", "First date missing.");
        }
        if (endDate == null) {
            throw CompanyManagementException.badRequest("SecondDateMissing", "Second date missing.");
        }
        return departmentMapper.toRestDTOs(departmentRepository.findByStartDateBetween(beginDate, endDate));
    }

    public List<DepartmentRestDTO> getDepartmentByNameIgnoreCase(String s) {
        if (s == null || s.isBlank()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search string is missing.");
        }
        return departmentMapper.toRestDTOs(departmentRepository.findByNameIgnoreCase(s));
    }

    public Department createDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(department);
    }

    public Department updateDepartment(DepartmentDTO departmentDTO, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Department updatedDepartment = department.get();
        updatedDepartment.setName(departmentDTO.getName());
        updatedDepartment.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(updatedDepartment);
    }

    public void deleteDepartment(Long deptId) {
        departmentRepository.deleteById(deptId);
    }


    public List<DepartmentWithNumOfProjectsDTO> getDeptWithNumberOfProjectsGreaterThan(Long num) {
        if(num == null){
            throw CompanyManagementException.badRequest("NumMissing", "Number of projects is missing.");
        }
        return departmentRepository.getDeptWithNumberOfProjectsGreaterThan(num);
    }

    public List<DepartmentWithNumOfEmployeeDTO> getDeptWithNumberOfEmployees() {
        return departmentRepository.getDeptWithNumberOfEmployees();
    }

    public List<DepartmentWithNumOfEmployeeDTO> getDeptWithMaxNumOfEmployees() {
        return departmentRepository.getDeptWithMaxNumOfEmployees();
    }

//    public List<DepartmentWithNumOfEmployeeDTO> getDeptWithNumberOfEmployeesGreaterThan(Long num) {
//        return departmentRepository.getDeptWithNumberOfEmployeesGreaterThan(num);
//    }


}
