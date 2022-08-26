package com.ahmetburak.employee.util;

import com.ahmetburak.employee.dto.DepartmentDTO;
import com.ahmetburak.employee.dto.EmployeeDTO;
import com.ahmetburak.employee.dto.EmploymentDetailDTO;
import com.ahmetburak.employee.dto.OfficeDTO;
import com.ahmetburak.employee.entity.Department;
import com.ahmetburak.employee.entity.Employee;
import com.ahmetburak.employee.entity.EmploymentDetail;
import com.ahmetburak.employee.entity.Office;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
public class TestUtil {
    public static final Long ID = 1L;
    public static final String FULL_NAME = "Ahmet Burak OZTURK";
    public static final LocalDate NOW = LocalDate.now();
    public static final LocalDateTime LOCAL_DATE_TIME_NOW = LocalDateTime.now();
    public static final EmployeeDTO EMPLOYEE_DTO = EmployeeDTO.builder().fullName(FULL_NAME).birthdate(NOW).id(ID).build();
    public static final Employee EMPLOYEE_ENTITY = Employee.builder().fullName(FULL_NAME).birthdate(NOW).build();

    public static final String NL_AMSTERDAM = "NL/Amsterdam";
    public static final String OFFICE_NAME = "ABC";
    public static final OfficeDTO OFFICE_DTO = OfficeDTO.builder().location(NL_AMSTERDAM).name(OFFICE_NAME).id(ID).build();
    public static final String TEST_DEPARTMENT = "Test Department";
    public static final DepartmentDTO DEPARTMENT_DTO = DepartmentDTO.builder().name(TEST_DEPARTMENT).id(ID).build();
    public static final EmploymentDetailDTO EMPLOYMENT_DETAIL_DTO = EmploymentDetailDTO.builder()
            .employee(EMPLOYEE_DTO)
            .department(DEPARTMENT_DTO)
            .office(OFFICE_DTO)
            .build();
    public static final Department DEPARTMENT_ENTITY = Department.builder().name(TEST_DEPARTMENT).build();
    public static final Office OFFICE_ENTITY = Office.builder().location(NL_AMSTERDAM).name(OFFICE_NAME).build();

    public static final EmploymentDetail EMPLOYMENT_DETAIL_ENTITY = EmploymentDetail.builder()
            .employee(EMPLOYEE_ENTITY)
            .department(DEPARTMENT_ENTITY)
            .office(OFFICE_ENTITY)
            .processTime(LOCAL_DATE_TIME_NOW)
            .startDate(NOW)
            .endDate(NOW)
            .build();
}
