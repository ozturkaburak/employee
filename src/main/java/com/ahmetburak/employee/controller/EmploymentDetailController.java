package com.ahmetburak.employee.controller;

import com.ahmetburak.employee.dto.EmploymentDetailDTO;
import com.ahmetburak.employee.service.EmploymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        return employmentDetailService.save(employmentDetailDTO);
    }

    @PutMapping
    public EmploymentDetailDTO update(@RequestBody EmploymentDetailDTO employmentDetailDTO) {
        return employmentDetailService.save(employmentDetailDTO);
    }

    @GetMapping("{employmentDetailId}")
    public EmploymentDetailDTO findById(@PathVariable Long employmentDetailId) {
        return employmentDetailService.findById(employmentDetailId);
    }

    @DeleteMapping("{employmentDetailId}")
    public void deleteById(@PathVariable Long employmentDetailId) {
         employmentDetailService.deleteById(employmentDetailId);
    }
}
