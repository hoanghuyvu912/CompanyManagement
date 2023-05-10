package com.example.demo.respository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByLastNameAndFirstName(String lastName, String firstName);

    List<Employee> findByLastNameOrFirstName(String lastName, String firstName);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findBySalaryLessThan(Integer salary);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> getEmployeesByDepartmentId(@Param("deptId") Long deptId);
}
