package com.example.demo.rest;

import com.example.demo.entity.Relatives;
import com.example.demo.service.RelativesService;
import com.example.demo.service.dto.RelativesDTO;
import com.example.demo.service.dto.RelativesRestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RelativesResource implements RelativesAPI {
    private final RelativesService relativesService;

    @Override
    public ResponseEntity<RelativesRestDTO> getRelativesById(Long relativesId, Long employeeId) {
        RelativesRestDTO relativesRestDTO = relativesService.getRelativesByID(relativesId, employeeId);
        return ResponseEntity.ok(relativesRestDTO);
    }

    @Override
    public ResponseEntity<Relatives> createRelatives(RelativesDTO relativesDTO, Long employeeId) {
        Relatives relatives = relativesService.createRelatives(relativesDTO, employeeId);
        return ResponseEntity.created(URI.create("/api/employee" + employeeId + "/relatives" + relatives.getId())).body(relatives);
    }


    @Override
    public ResponseEntity<Relatives> updateRelatives(RelativesDTO relativesDTO, Long employeeId, Long relativesId) {
        Relatives relatives = relativesService.updateRelatives(relativesDTO, relativesId);
        return ResponseEntity.ok().body(relatives);
    }

    @Override
    public ResponseEntity<Void> deleteRelatives(Long relativesId) {
        relativesService.deleteRelatives(relativesId);
        return ResponseEntity.noContent().build();
    }
}
