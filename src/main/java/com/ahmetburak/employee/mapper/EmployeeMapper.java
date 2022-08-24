package com.ahmetburak.employee.mapper;

import com.ahmetburak.employee.dto.EmployeeDTO;
import com.ahmetburak.employee.entity.Employee;
import org.mapstruct.Mapper;

/**
 * Created by ahmetburakozturk on 23.08.2022
 **/
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employee);
}
