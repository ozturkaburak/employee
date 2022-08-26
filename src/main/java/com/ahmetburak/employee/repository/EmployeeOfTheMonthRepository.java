package com.ahmetburak.employee.repository;

import com.ahmetburak.employee.dto.EmployeeOfTheMonthProjection;
import com.ahmetburak.employee.entity.EmployeeOfTheMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@Repository
public interface EmployeeOfTheMonthRepository extends JpaRepository<EmployeeOfTheMonth, Long> {

    @Query("select eom from EmployeeOfTheMonth eom where eom.month=:currentMonth")
    EmployeeOfTheMonthProjection findEmployeeOfTheMonth(Month currentMonth);

}
