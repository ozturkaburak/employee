package com.ahmetburak.employee.service.unit;

import com.ahmetburak.employee.dto.EmployeeDTO;
import com.ahmetburak.employee.entity.Employee;
import com.ahmetburak.employee.mapper.EmployeeMapper;
import com.ahmetburak.employee.repository.EmployeeRepository;
import com.ahmetburak.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ahmetburak.employee.util.TestUtil.EMPLOYEE_DTO;
import static com.ahmetburak.employee.util.TestUtil.EMPLOYEE_ENTITY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeeMapper employeeMapper;

    @Mock
    EmployeeRepository employeeRepository;


    @Test
    void testSaveOrUpdate() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(EMPLOYEE_ENTITY);
        when(employeeMapper.toEntity(any(EmployeeDTO.class))).thenReturn(EMPLOYEE_ENTITY);
        when(employeeMapper.toDTO(any(Employee.class))).thenReturn(EMPLOYEE_DTO);

        EmployeeDTO actualDTO = employeeService.saveOrUpdate(EMPLOYEE_DTO);

        verify(employeeRepository, times(1)).save(EMPLOYEE_ENTITY);
        assertEquals(EMPLOYEE_DTO.getFullName(), actualDTO.getFullName());
    }

    @Test
    void testDeleteById() {
        doNothing().when(employeeRepository).deleteById(anyLong());

        employeeService.deleteById(1L);

        verify(employeeRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindById() {
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(EMPLOYEE_ENTITY));
        when(employeeMapper.toDTO(any(Employee.class))).thenReturn(EMPLOYEE_DTO);

        EmployeeDTO actualDTO = employeeService.findById(1L);

        verify(employeeRepository, times(1)).findById(1L);
        assertEquals(EMPLOYEE_ENTITY.getFullName(), actualDTO.getFullName());
    }


    @Test
    void testFindEntityById() {
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(EMPLOYEE_ENTITY));
        when(employeeMapper.toDTO(any(Employee.class))).thenReturn(EMPLOYEE_DTO);

        EmployeeDTO actualDTO = employeeService.findById(1L);

        verify(employeeRepository, times(1)).findById(1L);
        assertEquals(EMPLOYEE_ENTITY.getFullName(), actualDTO.getFullName());
    }

    @Test
    void testFindAllByEmploymentDetailsByStartDateAndSalary() {
        List<Object[]> responseList = new ArrayList<>();
        responseList.add(new Object[]{});

        when(employeeRepository.findAllByEmploymentDetailsByStartDateAndSalary(any(LocalDate.class), anyDouble())).thenReturn(responseList);

        LocalDate now = LocalDate.now();
        employeeService.findAllByEmploymentDetailsByStartDateAndSalary(now, 1D);

        verify(employeeRepository, times(1)).findAllByEmploymentDetailsByStartDateAndSalary(now, 1D);
    }

    @Test
    void getCount() {
        when(employeeRepository.getCount()).thenReturn(1L);

        employeeService.getCount();

        verify(employeeRepository, times(1)).getCount();
    }


}
