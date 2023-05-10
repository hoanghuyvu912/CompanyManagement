package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.exception.CompanyManagementException;
import com.example.demo.respository.DepartmentRepository;
import com.example.demo.respository.EmployeeRepository;
import com.example.demo.service.dto.EmployeeDTO;
import com.example.demo.service.dto.EmployeeRestDTO;
import com.example.demo.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeRestDTO> getAllEmployee() {
        return employeeMapper.toRestDTOs(employeeRepository.findAll());
    }

    public EmployeeRestDTO getEmployeeById(Long employeeId, Long deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(CompanyManagementException::DepartmentNotFound);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(CompanyManagementException::EmployeeNotFound);
        return employeeMapper.toRestDTO(employee);
    }

    public List<EmployeeRestDTO> getEmployeeByLastNameAndFirstName(String lastName, String firstName) {
        if (lastName == null || lastName.trim().isBlank() || lastName.isEmpty()) {
            throw CompanyManagementException.badRequest("LastNameMissing", "Last name is missing.");
        }
        if (firstName == null || firstName.trim().isBlank() || firstName.isEmpty()) {
            throw CompanyManagementException.badRequest("FirstNameMissing", "First name is missing.");
        }
        return employeeMapper.toRestDTOs(employeeRepository.findByLastNameAndFirstName(lastName, firstName));
    }

//    public List<Employee> getEmployeeByLastNameAndFirstNameInDepartment(String lastName, String firstName, Long deptId) {
//        Optional<Department> department = departmentRepository.findById(deptId);
//        Optional<Employee> optionalEmployee = null;
//        if (department.isPresent()) {
//            optionalEmployee = employeeRepository.findById(employeeId);
//        }
//        employeeRepository.
//        return employeeRepository.findByLastNameAndFirstName(lastName, firstName);
//    }

    public List<EmployeeRestDTO> getEmployeeByLastNameOrFirstName(String lastName, String firstName) {
        if (lastName == null || lastName.trim().isBlank() || lastName.isEmpty() || firstName == null || firstName.trim().isBlank() || firstName.isEmpty()) {
            throw CompanyManagementException.badRequest("LastNameMissing", "Last name is missing.");
        }
        return employeeMapper.toRestDTOs(employeeRepository.findByLastNameOrFirstName(lastName, firstName));
    }

    public List<EmployeeRestDTO> getEmployeeByFirstName(String firstName) {
        if (firstName == null || firstName.trim().isBlank() || firstName.isEmpty()) {
            throw CompanyManagementException.badRequest("FirstNameMissing", "First name is missing.");
        }
        return employeeMapper.toRestDTOs(employeeRepository.findByFirstName(firstName));
    }

    public List<EmployeeRestDTO> getEmployeeBySalaryLessThan(Integer salary) {
        if (salary <= 0) {
            throw CompanyManagementException.badRequest("InvalidSalaryInput", "Salary must be a positive number.");
        }
        return employeeMapper.toRestDTOs(employeeRepository.findBySalaryLessThan(salary));
    }

    public List<EmployeeRestDTO> getEmployeeBySalaryGreaterThan(Integer salary) {
        if (salary <= 0) {
            throw CompanyManagementException.badRequest("InvalidSalaryInput", "Salary must be a positive number.");
        }
        return employeeMapper.toRestDTOs(employeeRepository.findBySalaryGreaterThan(salary));
    }

    public EmployeeRestDTO createEmployee(EmployeeDTO employeeDTO, Long deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(CompanyManagementException::DepartmentNotFound);

//        Optional<Department> department = departmentRepository.findById(deptId);
        Employee employee = new Employee();
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setGender(employeeDTO.getGender());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartment(department);
        return employeeMapper.toRestDTO(employeeRepository.save(employee));
    }

    public EmployeeRestDTO updateEmployee(EmployeeDTO employeeDTO, Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Employee updatedEmployee = employee.get();
        updatedEmployee.setDateOfBirth(employeeDTO.getDateOfBirth());
        updatedEmployee.setFirstName(employeeDTO.getFirstName());
        updatedEmployee.setLastName(employeeDTO.getLastName());
        updatedEmployee.setMiddleName(employeeDTO.getMiddleName());
        updatedEmployee.setGender(employeeDTO.getGender());
        updatedEmployee.setSalary(employeeDTO.getSalary());
        return employeeMapper.toRestDTO(employeeRepository.save(updatedEmployee));
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<EmployeeRestDTO> getEmployeesByDepartmentId(Long deptId) {
        Department department = departmentRepository.findById(deptId).orElseThrow(CompanyManagementException::DepartmentNotFound);
        return employeeMapper.toRestDTOs(employeeRepository.getEmployeesByDepartmentId(deptId));
    }
}
