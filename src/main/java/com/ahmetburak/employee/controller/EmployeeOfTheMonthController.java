package com.ahmetburak.employee.controller;

import com.ahmetburak.employee.dto.EmployeeOfTheMonthProjection;
import com.ahmetburak.employee.service.EmployeeOfTheMonthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@RestController
@RequestMapping("employeeOfTheMonth")
@RequiredArgsConstructor
public class EmployeeOfTheMonthController {

    private final EmployeeOfTheMonthService employeeOfTheMonthService;

    @GetMapping
    public EmployeeOfTheMonthProjection findEmployeeOfTheMonth() {
        return employeeOfTheMonthService.findEmployeeOfTheMonth();
    }
}
