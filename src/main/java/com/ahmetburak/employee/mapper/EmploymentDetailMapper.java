package com.ahmetburak.employee.mapper;

import com.ahmetburak.employee.dto.EmploymentDetailDTO;
import com.ahmetburak.employee.entity.EmploymentDetail;
import org.mapstruct.Mapper;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/

@Mapper(componentModel = "spring")
public interface EmploymentDetailMapper {

    EmploymentDetailDTO toDTO(EmploymentDetail employmentDetail);
    EmploymentDetail toEntity(EmploymentDetailDTO employmentDetailDTO);
}
