package com.ahmetburak.employee.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@Data
public class EmploymentDetailDTO extends BaseDTO{

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

//    @JsonBackReference
    private EmployeeDTO employee;
}
