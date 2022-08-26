package com.ahmetburak.employee.dto;

import com.ahmetburak.employee.entity.Employee;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
public interface EmployeeOfTheMonthProjection {
    LocalDateTime getTime();

    Month getMonth();

    Employee getEmployee();
}
