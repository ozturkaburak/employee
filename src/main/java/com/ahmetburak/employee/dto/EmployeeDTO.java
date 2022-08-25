package com.ahmetburak.employee.dto;

import com.ahmetburak.employee.entity.EmploymentDetail;
import com.ahmetburak.employee.entity.Payroll;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by ahmetburakozturk on 23.08.2022
 **/
@Data
public class EmployeeDTO extends BaseDTO {

    private Long id;

    @NotNull
    private String fullName;

    @NotNull
    private LocalDate birthdate;

//    @JsonManagedReference
    private List<PayrollDTO> payrolls = new java.util.ArrayList<>();

    //    @JsonIgnore
//    @JsonManagedReference
    private EmploymentDetailDTO employmentDetail;
}
