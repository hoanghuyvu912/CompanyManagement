package com.example.demo.service.dto;

import com.example.demo.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRestDTO {
    private Long id;
    private String area;
    private String projectName;
    private Department department;
}
