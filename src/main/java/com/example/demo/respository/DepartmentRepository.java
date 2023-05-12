package com.example.demo.respository;

import com.example.demo.entity.Department;
import com.example.demo.service.dto.DepartmentWithNumOfEmployeeDTO;
import com.example.demo.service.dto.DepartmentWithNumOfProjectsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByStartDate(LocalDate startDate);

    List<Department> findByStartDateAfter(LocalDate startDate);

    List<Department> findByStartDateBefore(LocalDate startDate);

    List<Department> findByStartDateBetween(LocalDate beginDate, LocalDate endDate);

    List<Department> findByNameIgnoreCase(String string);

    List<DepartmentWithNumOfProjectsDTO> getDeptWithNumberOfProjectsGreaterThan(@Param("num") Long num);

    List<DepartmentWithNumOfEmployeeDTO> getDeptWithNumberOfEmployees();

    @Query(nativeQuery=true)
    List<DepartmentWithNumOfEmployeeDTO> getDeptWithMaxNumOfEmployees();

//    List<DepartmentWithNumOfEmployeeDTO> getDeptWithNumberOfEmployeesGreaterThan(@Param("num") Long num);
}

