package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentWithNumOfProjectsDTO {
    private Long id;
    private String name;
    private Long numberOfProjects;
}
