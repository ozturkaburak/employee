package com.ahmetburak.employee.repository;

import com.ahmetburak.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by ahmetburakozturk on 23.08.2022
 **/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select p.employee.fullName,max(p.salary) from EmploymentDetail ed inner join Payroll p on p.employee.id=ed.employee.id and ed.startDate>=:startDate and p.salary>=:lowerSalaryLimit group by p.employee.fullName")
    List<Object[]> findAllByEmploymentDetailsByStartDateAndSalary(LocalDate startDate, Double lowerSalaryLimit);

    @Query("select count(e) from Employee e")
    long getCount();

}
