package com.ahmetburak.employee.service.unit;

import com.ahmetburak.employee.entity.EmploymentDetail;
import com.ahmetburak.employee.mapper.EmploymentDetailMapper;
import com.ahmetburak.employee.repository.EmploymentDetailRepository;
import com.ahmetburak.employee.service.DepartmentService;
import com.ahmetburak.employee.service.EmployeeService;
import com.ahmetburak.employee.service.EmploymentDetailService;
import com.ahmetburak.employee.service.OfficeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static com.ahmetburak.employee.util.TestUtil.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@ExtendWith(MockitoExtension.class)
class EmploymentDetailServiceTest {


    @InjectMocks
    EmploymentDetailService employmentDetailService;

    @Mock
    EmploymentDetailMapper employmentDetailMapper;

    @Mock
    EmploymentDetailRepository employmentDetailRepository;

    @Mock
    OfficeService officeService;

    @Mock
    EmployeeService employeeService;

    @Mock
    DepartmentService departmentService;

    @Test
    void testSaveOrUpdate() {
        when(officeService.findById(anyLong())).thenReturn(OFFICE_DTO);
        when(employeeService.findById(anyLong())).thenReturn(EMPLOYEE_DTO);
        when(departmentService.findById(anyLong())).thenReturn(DEPARTMENT_DTO);
        when(employmentDetailMapper.toEntity(EMPLOYMENT_DETAIL_DTO)).thenReturn(EMPLOYMENT_DETAIL_ENTITY);

        employmentDetailService.saveOrUpdate(EMPLOYMENT_DETAIL_DTO);

        verify(employmentDetailRepository, times(1)).save(EMPLOYMENT_DETAIL_ENTITY);

    }

    @Test
    void testDeleteById() {
        doNothing().when(employmentDetailRepository).deleteById(anyLong());

        employmentDetailRepository.deleteById(ID);

        verify(employmentDetailRepository, times(1)).deleteById(ID);

    }

    @Test
    void testFindById() {
        when(employmentDetailRepository.findById(anyLong())).thenReturn(Optional.of(EMPLOYMENT_DETAIL_ENTITY));
        when(employmentDetailMapper.toDTO(any(EmploymentDetail.class))).thenReturn(EMPLOYMENT_DETAIL_DTO);

        employmentDetailService.findById(ID);

        verify(employmentDetailRepository, times(1)).findById(ID);
    }

    @Test
    void findAllByEmployeeId() {
        final Pageable paging = PageRequest.of(0, 10, Sort.by("id").descending());

        employmentDetailService.findAllByEmployeeId(0, 10, ID);

        verify(employmentDetailRepository, times(1)).findAllByEmployee_Id(ID, paging);
    }

    @Test
    void updateOfficeLocationByDepartmentId() {
        List<EmploymentDetail> employmentDetailEntity = List.of(EMPLOYMENT_DETAIL_ENTITY);
        when(employmentDetailRepository.findAllByDepartment_Id(anyLong())).thenReturn(employmentDetailEntity);
        when(officeService.findEntityById(anyLong())).thenReturn(OFFICE_ENTITY);

        employmentDetailService.updateOfficeLocationByDepartmentId(ID, ID);

        verify(employmentDetailRepository, times(1)).findAllByDepartment_Id(ID);
        verify(officeService, times(1)).findEntityById(ID);

    }

}
