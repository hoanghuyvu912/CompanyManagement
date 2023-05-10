package com.example.demo.service.mapper;

import com.example.demo.entity.Location;
import com.example.demo.service.dto.LocationDTO;
import com.example.demo.service.dto.LocationRestDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDTO toDTO(Location location);

    LocationRestDTO toRestDTO(Location location);

    List<LocationDTO> toDTOs(List<Location> locations);

    List<LocationRestDTO> toRestDTOs(List<Location> locations);

}
