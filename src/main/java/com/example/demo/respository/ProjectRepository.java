package com.example.demo.respository;

import com.example.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByProjectNameNot(String string);

    List<Project> findByAreaIsNull();

    List<Project> findByAreaNotNull();

    List<Project> findAllProjectByOrderByProjectName();

    List<Project> findByAreaIgnoreCase(String string);
}
