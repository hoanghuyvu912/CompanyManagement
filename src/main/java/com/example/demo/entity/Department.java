package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Department")
@SqlResultSetMapping(
        name = "DepartmentWithMaxEmployees",
        classes = {
                @ConstructorResult(
                        targetClass = com.example.demo.service.dto.DepartmentWithNumOfEmployeeDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "numberOfEmployees", type = Long.class)
                        }
                )
        }
)
@NamedQueries({
        @NamedQuery(
                name = "Department.getDeptWithNumberOfProjectsGreaterThan",
                query = "SELECT new com.example.demo.service.dto.DepartmentWithNumOfProjectsDTO(d.id, d.name, count(p.id)) from Department d join Project p on d.id = p.department.id group by d.id having count(p.id) > :num"
        ),
        @NamedQuery(
                name = "Department.getDeptWithNumberOfEmployees",
                query = "SELECT new com.example.demo.service.dto.DepartmentWithNumOfEmployeeDTO(d.id, d.name, count(e.id)) from Department d join Employee e on d.id = e.department.id group by d.id"
        )

})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Department.getDeptWithMaxNumOfEmployees",
                query = "SELECT d.id as id, d.name as name, count(e.id) as numberOfEmployees from department d join employee e on d.id = e.dept_id group by d.id " +
                        "having count(e.id) = (select max(g.c) from (select count(e2.id) as c from employee e2 group by e2.dept_id) as g)",
                resultSetMapping = "DepartmentWithMaxEmployees"
        )
})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "start_Date")
    private LocalDate startDate;
}
