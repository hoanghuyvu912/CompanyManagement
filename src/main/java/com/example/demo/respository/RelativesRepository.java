package com.example.demo.respository;

import com.example.demo.entity.Location;
import com.example.demo.entity.Relatives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelativesRepository extends JpaRepository<Relatives, Long> {
    List<Relatives> findAllByOrderByFullNameAsc();

    List<Relatives> findByFullNameStartingWith(String string);

    List<Relatives> findByFullNameEndingWith(String string);

    List<Relatives> findByPhoneNumberContaining(String string);

    List<Relatives> findByRelationshipEquals(String string);

    List<Relatives> getRelativesByEmployeeId(@Param("employeeId") Long employeeId);
}
