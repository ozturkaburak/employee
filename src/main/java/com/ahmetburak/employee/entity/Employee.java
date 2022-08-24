package com.ahmetburak.employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by ahmetburakozturk on 23.08.2022
 **/
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String fullname;

    @NotNull
    private LocalDate birthdate;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Payroll> payrolls = new java.util.ArrayList<>();

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private EmploymentDetail employmentDetail;
}
