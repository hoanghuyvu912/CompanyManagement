package com.example.demo.respository;

import com.example.demo.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByNumberOfHourLessThan(Integer h);

    List<Assignment> findByNumberOfHourLessThanEqual(Integer h);

    List<Assignment> findByNumberOfHourGreaterThan(Integer h);

    List<Assignment> findByNumberOfHourGreaterThanEqual(Integer h);

    List<Assignment> findByNumberOfHourBetween(Integer h1, Integer h2);
}
