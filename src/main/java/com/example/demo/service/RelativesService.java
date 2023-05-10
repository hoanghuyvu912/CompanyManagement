package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Relatives;
import com.example.demo.exception.CompanyManagementException;
import com.example.demo.respository.EmployeeRepository;
import com.example.demo.respository.RelativesRepository;
import com.example.demo.service.dto.RelativesDTO;
import com.example.demo.service.dto.RelativesRestDTO;
import com.example.demo.service.mapper.RelativesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativesService {
    private final RelativesRepository relativesRepository;
    private final EmployeeRepository employeeRepository;
    private final RelativesMapper relativesMapper;

    public List<RelativesRestDTO> getAllRelatives() {
        return relativesMapper.toRestDTOs(relativesRepository.findAll());
    }

    public RelativesRestDTO getRelativesByID(Long relativesId, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(CompanyManagementException::EmployeeNotFound);
        Relatives relatives = relativesRepository.findById(relativesId).orElseThrow(CompanyManagementException::RelativesNotFound);
        return relativesMapper.toRestDTO(relatives);
    }

    public List<RelativesRestDTO> getAllRelativesByOrderByFullNameAsc() {
        return relativesMapper.toRestDTOs(relativesRepository.findAllByOrderByFullNameAsc());
    }

    public List<RelativesRestDTO> getRelativesByFullNameStartingWith(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search string is missing.");
        }
        return relativesMapper.toRestDTOs(relativesRepository.findByFullNameStartingWith(s));
    }

    public List<RelativesRestDTO> getRelativesByFullNameEndingWith(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search string is missing.");
        }
        return relativesMapper.toRestDTOs(relativesRepository.findByFullNameEndingWith(s));
    }

    public List<RelativesRestDTO> getRelativesByPhoneNumberContaining(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search string is missing.");
        }
        return relativesMapper.toRestDTOs(relativesRepository.findByPhoneNumberContaining(s));
    }

    public List<RelativesRestDTO> getRelativesByRelationshipEquals(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw CompanyManagementException.badRequest("StringMissing", "Search string is missing.");
        }
        return relativesMapper.toRestDTOs(relativesRepository.findByRelationshipEquals(s));
    }


    public RelativesRestDTO createRelatives(RelativesDTO relativesDTO, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(CompanyManagementException::EmployeeNotFound);
        Relatives relatives = new Relatives();
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setGender(relativesDTO.getGender());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        relatives.setRelationship(relativesDTO.getRelationship());
        relatives.setEmployee(employee);
        return relativesMapper.toRestDTO(relativesRepository.save(relatives));
    }

    public RelativesRestDTO updateRelatives(RelativesDTO relativesDTO, Long relativesId) {
        Relatives relatives = relativesRepository.findById(relativesId).orElseThrow(CompanyManagementException::RelativesNotFound);
        relatives.setGender(relativesDTO.getGender());
        relatives.setRelationship(relativesDTO.getRelationship());
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        return relativesMapper.toRestDTO(relativesRepository.save(relatives));
    }

    public void deleteRelatives(Long relativesId) {
        relativesRepository.deleteById(relativesId);
    }

    public List<RelativesRestDTO> getRelativesByEmployeeId(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(CompanyManagementException::EmployeeNotFound);
        return relativesMapper.toRestDTOs(relativesRepository.getRelativesByEmployeeId(employeeId));
    }
}
