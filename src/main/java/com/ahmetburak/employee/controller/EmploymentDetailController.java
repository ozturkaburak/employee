package com.ahmetburak.employee.controller;

import com.ahmetburak.employee.dto.EmploymentDetailDTO;
import com.ahmetburak.employee.service.EmploymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@RestController
@RequestMapping("employment/details")
@RequiredArgsConstructor
public class EmploymentDetailController {

    private final EmploymentDetailService employmentDetailService;

    @PostMapping
    public EmploymentDetailDTO save(@RequestBody EmploymentDetailDTO employmentDetailDTO) {
        return employmentDetailService.saveOrUpdate(employmentDetailDTO);
    }

    @PutMapping
    public EmploymentDetailDTO update(@RequestBody EmploymentDetailDTO employmentDetailDTO) {
        return employmentDetailService.saveOrUpdate(employmentDetailDTO);
    }

    @GetMapping("{employmentDetailId}")
    public EmploymentDetailDTO findById(@PathVariable Long employmentDetailId) {
        return employmentDetailService.findById(employmentDetailId);
    }

    @GetMapping("all/{employeeId}")
    public List<EmploymentDetailDTO> findById(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @PathVariable Long employeeId) {
        return employmentDetailService.findAllByEmployeeId(pageNo, pageSize, employeeId);
    }

    @DeleteMapping("{employmentDetailId}")
    public void deleteById(@PathVariable Long employmentDetailId) {
        employmentDetailService.deleteById(employmentDetailId);
    }

    @PutMapping("update")
    public void updateOfficeLocationByDepartmentId(@RequestParam Long officeId, @RequestParam Long departmentId) {
        employmentDetailService.updateOfficeLocationByDepartmentId(officeId, departmentId);
    }

}
