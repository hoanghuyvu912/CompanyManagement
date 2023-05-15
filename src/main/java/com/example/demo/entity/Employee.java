package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(
                name = "Employee.getEmployeesByDepartmentId",
                query = "SELECT e from Employee e where e.department.id = :deptId"
        )
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "first_name")
    private String firstName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "salary")
    private int salary;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
}
