package com.example.demo.service.dto;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentRestDTO {
    private Long id;
    private int numberOfHour;
    private Employee employee;
    private Project project;
}
