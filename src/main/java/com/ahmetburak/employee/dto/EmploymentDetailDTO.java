package com.ahmetburak.employee.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@Data
@Builder
public class EmploymentDetailDTO extends BaseDTO {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime processTime;
    private EmployeeDTO employee;
    private DepartmentDTO department;
    private OfficeDTO office;
}
