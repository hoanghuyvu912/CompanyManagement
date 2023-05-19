package com.example.demo.service.mapper;

import com.example.demo.entity.Relatives;
import com.example.demo.service.dto.RelativesDTO;
import com.example.demo.service.dto.RelativesRestDTO;
import com.example.demo.service.dtoForJava8.RelativeJava8Dto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RelativesMapper {
    RelativesDTO toDTO(Relatives relatives);

    RelativesRestDTO toRestDTO(Relatives relatives);

    List<RelativesDTO> toDTOs(List<Relatives> relatives);
    
    List<RelativesRestDTO> toRestDTOs(List<Relatives> relatives);

    RelativeJava8Dto toJava8DTO(RelativesRestDTO relativesRestDTO);

    List<RelativeJava8Dto> toJava8DTOs(List<RelativesRestDTO> relativesRestDTOList);
}
