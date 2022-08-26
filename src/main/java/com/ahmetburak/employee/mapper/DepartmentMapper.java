package com.ahmetburak.employee.mapper;

import com.ahmetburak.employee.dto.DepartmentDTO;
import com.ahmetburak.employee.entity.Department;
import org.mapstruct.Mapper;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDTO toDTO(Department department);

    Department toEntity(DepartmentDTO departmentDTO);
}
