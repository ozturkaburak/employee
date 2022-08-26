package com.ahmetburak.employee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@Entity
@Getter
@Setter
public class EmployeeOfTheMonth extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Employee employee;

    @Enumerated(EnumType.STRING)
    private Month month;
    private LocalDateTime time;

}
