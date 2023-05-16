package com.example.demo.service.dtoForJava8;

public class ProjectWithTotalHoursTotalSalaryDto {
    private Integer totalHours;
    private Double totalSalary;

    public ProjectWithTotalHoursTotalSalaryDto() {
        this(0, 0D);
    }

    public ProjectWithTotalHoursTotalSalaryDto(Integer totalHours, Double totalSalary) {
        this.totalHours = totalHours;
        this.totalSalary = totalSalary;
    }

    public Integer getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Integer totalHours) {
        this.totalHours = totalHours;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

    @Override
    public String toString() {
        return  "Total Hours: " + totalHours +
                "\nTotal Salary: " + totalSalary;
    }
}
