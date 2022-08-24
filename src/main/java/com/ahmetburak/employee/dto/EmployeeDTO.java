package com.ahmetburak.employee.dto;

import com.ahmetburak.employee.entity.EmploymentDetail;
import com.ahmetburak.employee.entity.Payroll;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by ahmetburakozturk on 23.08.2022
 **/
@Data
public class EmployeeDTO extends BaseDTO{

    private Long id;

    @NotNull
    private String fullname;

    @NotNull
    private LocalDate birthdate;

    private List<Payroll> payrolls = new java.util.ArrayList<>();

    private EmploymentDetail employmentDetail;
}
