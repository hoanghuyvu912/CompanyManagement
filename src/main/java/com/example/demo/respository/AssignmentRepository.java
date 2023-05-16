package com.example.demo.respository;

import com.example.demo.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByNumberOfHourLessThan(Integer h);

    List<Assignment> findByNumberOfHourLessThanEqual(Integer h);

    List<Assignment> findByNumberOfHourGreaterThan(Integer h);

    List<Assignment> findByNumberOfHourGreaterThanEqual(Integer h);

    List<Assignment> findByNumberOfHourBetween(Integer h1, Integer h2);

    @Query(value = "SELECT a from Assignment a join Employee e on a.employee.id = e.id where e.id = :employeeId")
    List<Assignment> getByEmployeeId(@Param("employeeId") Long employeeId);
}
