package com.example.demo.service.dtoForJava8;

public class ProjectWithTotalEmpTotalHourDto {
    private Integer numberOfEmployees;
    private Integer numberOfHours;

    public ProjectWithTotalEmpTotalHourDto() {
        this(0, 0);
    }

    public ProjectWithTotalEmpTotalHourDto(Integer numberOfEmployees, Integer numberOfHours) {
        this.numberOfEmployees = numberOfEmployees;
        this.numberOfHours = numberOfHours;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(Integer numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    @Override
    public String toString() {
        return "ProjectWithTotalEmpTotalHour:" +
                "\nNumber Of Employees: " + numberOfEmployees +
                "\nNumber Of Hours: " + numberOfHours + "\n";
    }
}
