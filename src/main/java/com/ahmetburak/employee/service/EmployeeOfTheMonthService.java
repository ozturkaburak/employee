package com.ahmetburak.employee.service;

import com.ahmetburak.employee.dto.EmployeeOfTheMonthProjection;
import com.ahmetburak.employee.entity.Employee;
import com.ahmetburak.employee.entity.EmployeeOfTheMonth;
import com.ahmetburak.employee.repository.EmployeeOfTheMonthRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class EmployeeOfTheMonthService {
    private final EmployeeOfTheMonthRepository employeeOfTheMonthRepository;
    private final EmployeeService employeeService;

    @Scheduled(cron = "${cron.expression}")
    @Async
    public void pickARandomEmployee() {
        long count = employeeService.getCount();
        if (count > 0) {
            long randomEmployeeId = RandomUtils.nextLong(1L, count);
            Employee entityById = employeeService.findEntityById(randomEmployeeId);
            if (Objects.isNull(entityById)) {
                log.error("Employee not found with ID: {}", randomEmployeeId);
                return;
            }
            LocalDateTime now = LocalDateTime.now();
            EmployeeOfTheMonth employeeOfTheMonth = new EmployeeOfTheMonth();
            employeeOfTheMonth.setEmployee(entityById);
            employeeOfTheMonth.setSelectionTime(now);
            employeeOfTheMonth.setSelectedMonth(now.getMonth());

            employeeOfTheMonthRepository.save(employeeOfTheMonth);
        }

    }

    public EmployeeOfTheMonthProjection findEmployeeOfTheMonth() {
        final Month month = LocalDate.now().getMonth();
        return employeeOfTheMonthRepository.findEmployeeOfTheMonth(month);
    }
}
