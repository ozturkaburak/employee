package com.ahmetburak.employee.service;

import com.ahmetburak.employee.dto.PayrollDTO;
import com.ahmetburak.employee.entity.Payroll;
import com.ahmetburak.employee.mapper.PayrollMapper;
import com.ahmetburak.employee.repository.PayrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class PayrollService {

    private final PayrollMapper payrollMapper;
    private final PayrollRepository payrollRepository;

    public PayrollDTO saveOrUpdate(PayrollDTO payrollDTO) {
        Payroll savedPayroll = payrollMapper.toEntity(payrollDTO);
        savedPayroll = payrollRepository.save(savedPayroll);
        return payrollMapper.toDTO(savedPayroll);
    }

    public PayrollDTO findById(Long payrollId) {
        Optional<Payroll> byId = payrollRepository.findById(payrollId);
        return byId.map(payrollMapper::toDTO).orElse(null);
    }

    public void deleteById(Long payrollId) {
        payrollRepository.deleteById(payrollId);
    }

    public List<PayrollDTO> findAllByUserId(Long userId) {
        List<Payroll> payrollList = payrollRepository.findAllByEmployee_Id(userId);
        return payrollList.stream().map(payrollMapper::toDTO).toList();
    }
}
