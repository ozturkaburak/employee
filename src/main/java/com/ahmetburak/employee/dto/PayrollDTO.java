package com.ahmetburak.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@Data
@Builder
@AllArgsConstructor
public class PayrollDTO extends BaseDTO{

    private Long id;

    private Double salary;
    @NotNull
    private LocalDate date;

//    @JsonBackReference
    @NotNull
    private EmployeeDTO employee;
}
