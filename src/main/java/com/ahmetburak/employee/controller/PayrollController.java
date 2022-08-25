package com.ahmetburak.employee.controller;

import com.ahmetburak.employee.dto.PayrollDTO;
import com.ahmetburak.employee.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@RestController
@RequestMapping("payrolls")
@RequiredArgsConstructor
public class PayrollController {

    private final PayrollService payrollService;

    @PostMapping
    public PayrollDTO save(@Valid @RequestBody PayrollDTO payrollDTO) {
        return payrollService.saveOrUpdate(payrollDTO);
    }

    @PutMapping
    public PayrollDTO update(@Valid @RequestBody PayrollDTO payrollDTO) {
        return payrollService.saveOrUpdate(payrollDTO);
    }

    @GetMapping("{payrollId}")
    public PayrollDTO findById(@PathVariable Long payrollId) {
        return payrollService.findById(payrollId);
    }

    @GetMapping("employees/{userId}")
    public List<PayrollDTO> findAllByUserId(@PathVariable Long userId) {
        return payrollService.findAllByUserId(userId);
    }

    @DeleteMapping("{payrollId}")
    public void deleteById(@PathVariable Long payrollId) {
        payrollService.deleteById(payrollId);
    }

}
