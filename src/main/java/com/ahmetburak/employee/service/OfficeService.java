package com.ahmetburak.employee.service;

import com.ahmetburak.employee.dto.OfficeDTO;
import com.ahmetburak.employee.entity.Office;
import com.ahmetburak.employee.mapper.OfficeMapper;
import com.ahmetburak.employee.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@Service
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeRepository officeRepository;
    private final OfficeMapper officeMapper;

    public OfficeDTO findById(Long officeId) {
        Office entityById = this.findEntityById(officeId);
        return Objects.nonNull(entityById) ? officeMapper.toDTO(entityById) : null;
    }

    public Office findEntityById(Long officeId) {
        Optional<Office> byId = officeRepository.findById(officeId);
        return byId.orElse(null);
    }
}
