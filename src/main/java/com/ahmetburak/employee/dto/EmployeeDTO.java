package com.ahmetburak.employee.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * Created by ahmetburakozturk on 23.08.2022
 **/
@Data
@Builder
public class EmployeeDTO extends BaseDTO {

    private Long id;

    private String fullName;
    private LocalDate birthdate;

}
