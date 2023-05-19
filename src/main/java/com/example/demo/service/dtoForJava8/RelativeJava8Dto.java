package com.example.demo.service.dtoForJava8;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelativeJava8Dto {
    private String fullName;
    private String relationship;
}
