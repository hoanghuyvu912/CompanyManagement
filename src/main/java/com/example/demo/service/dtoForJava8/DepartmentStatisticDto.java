package com.example.demo.service.dtoForJava8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentStatisticDto {
    private String name;
    private LocalDate startDate;
    private Integer numberOfEmployee;
    private Integer numberOfFemales;
    private Integer numberOfMale;
    private Integer numberOfU23;

    @Override
    public String toString() {
        return "Department Statistic: " +
                "\nName: " + name +
                "\nStartDate: " + startDate +
                "\nNumber Of Employees: " + numberOfEmployee +
                "\nNumber Of Females: " + numberOfFemales +
                "\nNumber Of Male: " + numberOfMale +
                "\nNumber Of U23: " + numberOfU23 +
                "\n\n";
    }
}
