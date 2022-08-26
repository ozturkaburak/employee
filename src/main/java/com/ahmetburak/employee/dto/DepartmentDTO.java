package com.ahmetburak.employee.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@Data
@Builder
public class DepartmentDTO extends BaseDTO {

    private Long id;
    private String name;
}
