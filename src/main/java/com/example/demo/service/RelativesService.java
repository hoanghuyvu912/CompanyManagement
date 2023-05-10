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
        return relativesMapper.toRestDTOs(relativesRepository.findByFullNameStartingWith(s));
    }

    public List<RelativesRestDTO> getRelativesByFullNameEndingWith(String s) {
        return relativesMapper.toRestDTOs(relativesRepository.findByFullNameEndingWith(s));
    }

    public List<RelativesRestDTO> getRelativesByPhoneNumberContaining(String s) {
        return relativesMapper.toRestDTOs(relativesRepository.findByPhoneNumberContaining(s));
    }

    public List<RelativesRestDTO> getRelativesByRelationshipEquals(String s) {
        return relativesMapper.toRestDTOs(relativesRepository.findByRelationshipEquals(s));
    }


    public Relatives createRelatives(RelativesDTO relativesDTO, Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Relatives relatives = new Relatives();
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setGender(relativesDTO.getGender());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        relatives.setRelationship(relativesDTO.getRelationship());
        if (employee.isPresent()) {
            relatives.setEmployee(employee.get());
        }
        return relativesRepository.save(relatives);
    }

    public Relatives updateRelatives(RelativesDTO relativesDTO, Long relativesId) {
        Optional<Relatives> relatives = relativesRepository.findById(relativesId);
        Relatives updatedRelatives = relatives.get();
        updatedRelatives.setGender(relativesDTO.getGender());
        updatedRelatives.setRelationship(relativesDTO.getRelationship());
        updatedRelatives.setFullName(relativesDTO.getFullName());
        updatedRelatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        return relativesRepository.save(updatedRelatives);
    }

    public void deleteRelatives(Long relativesId) {
        relativesRepository.deleteById(relativesId);
    }

    public List<RelativesRestDTO> getRelativesByEmployeeId(Long employeeId) {
        return relativesMapper.toRestDTOs(relativesRepository.getRelativesByEmployeeId(employeeId));
    }
}
