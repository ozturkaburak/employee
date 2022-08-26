package com.ahmetburak.employee.service;

import com.ahmetburak.employee.dto.EmployeeDTO;
import com.ahmetburak.employee.entity.Employee;
import com.ahmetburak.employee.mapper.EmployeeMapper;
import com.ahmetburak.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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
        return employeeMapper.toDTO(savedEmployee);
    }

    public void deleteById(Long userId) {
        employeeRepository.deleteById(userId);
    }

    public EmployeeDTO findById(Long userId) {
        Employee entityById = this.findEntityById(userId);

        return Objects.nonNull(entityById) ? employeeMapper.toDTO(entityById) : null;
    }

    public Employee findEntityById(Long userId) {
        Optional<Employee> byId = employeeRepository.findById(userId);
        return byId.isEmpty() ? null : byId.get();
    }

    public List<Object[]> findAllByEmploymentDetailsByStartDateAndSalary(LocalDate startDate, Double lowerSalaryLimit) {
        return employeeRepository.findAllByEmploymentDetailsByStartDateAndSalary(startDate, lowerSalaryLimit);
    }

    public long getCount() {
        return employeeRepository.getCount();
    }

}
