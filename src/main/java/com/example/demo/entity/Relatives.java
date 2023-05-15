package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "relative")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Relatives.getRelativesByEmployeeId",
                query = "SELECT * from relative r join employee e on r.employee_id = e.id where e.id = :employeeId",
                resultClass = Relatives.class
        )
})
public class Relatives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated
    private Gender gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "relationship")
    private String relationship;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
