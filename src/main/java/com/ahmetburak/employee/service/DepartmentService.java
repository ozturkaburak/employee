package com.ahmetburak.employee.service;

import com.ahmetburak.employee.dto.DepartmentDTO;
import com.ahmetburak.employee.entity.Department;
import com.ahmetburak.employee.mapper.DepartmentMapper;
import com.ahmetburak.employee.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentDTO findById(Long departmentId) {
        Optional<Department> byId = departmentRepository.findById(departmentId);
        return byId.map(departmentMapper::toDTO).orElse(null);
    }
}
