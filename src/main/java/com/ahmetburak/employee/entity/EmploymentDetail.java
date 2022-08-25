package com.ahmetburak.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by ahmetburakozturk on 23.08.2022
 **/

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class EmploymentDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate startDate;
    private LocalDate endDate;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "user_id",unique = true,nullable = false)
    private Employee employee;
}
