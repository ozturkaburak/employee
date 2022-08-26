package com.ahmetburak.employee.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@Data
public class EmployeeDetailDTO extends BaseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EmployeeDTO employee;

    private DepartmentDTO department;

    private OfficeDTO office;

    private LocalDateTime lastUpdatedDate;

    private LocalDate startDate;
    private LocalDate endDate;


}
