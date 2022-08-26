package com.ahmetburak.employee.controller;

import com.ahmetburak.employee.dto.EmployeeDTO;
import com.ahmetburak.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by ahmetburakozturk on 23.08.2022
 **/
@RestController
@RequestMapping("employees")
@Log4j2
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveOrUpdate(employeeDTO);
    }

    @PutMapping
    public EmployeeDTO saveOrUpdate(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveOrUpdate(employeeDTO);
    }

    @GetMapping("{userId}")
    public EmployeeDTO findById(@PathVariable Long userId) {
        return employeeService.findById(userId);
    }

    @DeleteMapping("{userId}")
    public void deleteById(@PathVariable Long userId) {
        employeeService.deleteById(userId);
    }

    @GetMapping("ses")
    public List<Object[]> findAllByEmploymentDetailsByStartDateAndSalary(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @RequestParam("lowerSalaryLimit") Double lowerSalaryLimit) {
        return employeeService.findAllByEmploymentDetailsByStartDateAndSalary(startDate, lowerSalaryLimit);
    }

}
