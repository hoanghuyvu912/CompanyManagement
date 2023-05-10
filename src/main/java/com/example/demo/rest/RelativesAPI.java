package com.example.demo.rest;

import com.example.demo.entity.Relatives;
import com.example.demo.service.dto.RelativesDTO;
import com.example.demo.service.dto.RelativesRestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/employees/{employeeId}/relatives")
public interface RelativesAPI {
    @GetMapping(value = "/{relativesId}")
    ResponseEntity<RelativesRestDTO> getRelativesById(@PathVariable("relativesId") Long relativesId, @PathVariable("employeeId") Long employeeId);

    @PostMapping
    ResponseEntity<Relatives> createRelatives(@RequestBody RelativesDTO relativesDTO, @PathVariable("employeeId") Long employeeId);

    @PutMapping(value = "/{relativesId}")
    ResponseEntity<Relatives> updateRelatives(@RequestBody RelativesDTO relativesDTO, @PathVariable("employeeId") Long employeeId, @PathVariable("relativesId") Long relativesId);

    @DeleteMapping(value = "/{relativesId}")
    ResponseEntity<Void> deleteRelatives(@PathVariable("relativesId") Long relativesId);
}
