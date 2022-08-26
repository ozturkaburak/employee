package com.ahmetburak.employee.mapper;

import com.ahmetburak.employee.dto.OfficeDTO;
import com.ahmetburak.employee.entity.Office;
import org.mapstruct.Mapper;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@Mapper(componentModel = "spring")
public interface OfficeMapper {

    OfficeDTO toDTO(Office office);

    Office toEntity(OfficeDTO office);
}
