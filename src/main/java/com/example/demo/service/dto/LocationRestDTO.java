package com.example.demo.service.dto;

import com.example.demo.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationRestDTO {
    private Long id;
    private String location;
    private Department department;
}
