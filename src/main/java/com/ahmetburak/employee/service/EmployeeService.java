package com.ahmetburak.employee.service;

import com.ahmetburak.employee.dto.EmployeeDTO;
import com.ahmetburak.employee.entity.Employee;
import com.ahmetburak.employee.mapper.EmployeeMapper;
import com.ahmetburak.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by ahmetburakozturk on 23.08.2022
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeDTO saveOrUpdate(EmployeeDTO employeeDTO) {
        Employee savedEmployee = employeeRepository.save(employeeMapper.toEntity(employeeDTO));
        savedEmployee.getPayrolls().stream().filter(payroll -> Objects.isNull(payroll.getEmployee())).forEach(payroll -> payroll.setEmployee(savedEmployee));
        return employeeMapper.toDTO(savedEmployee);
    }

    public void deleteById(Long userId) {
        employeeRepository.deleteById(userId);
    }

    public EmployeeDTO findById(Long userId) {
        Optional<Employee> byId = employeeRepository.findById(userId);
        return byId.map(employeeMapper::toDTO).orElse(null);
    }

    public List<Object[]> findAllByEmploymentDetail_StartDateAfterAndPayrolls(){
        LocalDate of = LocalDate.of(2022, 8, 31);
        System.err.println(of);
        return employeeRepository.findAllByEmploymentDetail_StartDateAfterAndPayrolls(of,7900D);
    }
}
