package com.ahmetburak.employee.mapper;

import com.ahmetburak.employee.dto.PayrollDTO;
import com.ahmetburak.employee.entity.Payroll;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@Mapper(componentModel = "spring")
public interface PayrollMapper {

    @Mapping(target = "employee", ignore = true)
    PayrollDTO toDTO(Payroll payroll);
    Payroll toEntity(PayrollDTO payrollDTO);
}
