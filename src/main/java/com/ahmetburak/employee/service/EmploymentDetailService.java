package com.ahmetburak.employee.service;

import com.ahmetburak.employee.dto.EmploymentDetailDTO;
import com.ahmetburak.employee.entity.EmploymentDetail;
import com.ahmetburak.employee.mapper.EmploymentDetailMapper;
import com.ahmetburak.employee.repository.EmploymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class EmploymentDetailService {

    private final EmploymentRepository employmentRepository;
    private final EmploymentDetailMapper employmentDetailMapper;

    public EmploymentDetailDTO save(EmploymentDetailDTO employmentDetailDTO) {
        EmploymentDetail employmentDetail = employmentDetailMapper.toEntity(employmentDetailDTO);
//        if(Objects.isNull(employmentDetail.getEmployee().getEmploymentDetail())){
//            employmentDetail.getEmployee().setEmploymentDetail(employmentDetail);
//        }
        employmentDetail = employmentRepository.save(employmentDetail);
        return employmentDetailMapper.toDTO(employmentDetail);
    }

    public void deleteById(Long employmentDetailId){
        employmentRepository.deleteById(employmentDetailId);
    }

    public EmploymentDetailDTO findById(Long employmentDetailId){
        Optional<EmploymentDetail> byId = employmentRepository.findById(employmentDetailId);
        return byId.map(employmentDetailMapper::toDTO).orElse(null);
    }
}
