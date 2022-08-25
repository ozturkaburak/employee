package com.ahmetburak.employee.repository;

import com.ahmetburak.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by ahmetburakozturk on 23.08.2022
 **/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * select e.* from employee e inner join (select p.employee_id, max(p.salary) from payroll p group by p.employee_id) payroll on e.id = payroll.employee_id inner join employment_detail ed on e.id = ed.user_id and ed.start_date < CURRENT_DATE
     *
     * @return
     */
//    @Query("select p.id, max(p.salary) from Payroll p group by p.employee.id")
//    @Query("select p.employee.id, max(p.salary) from Employee e inner join EmploymentDetail ed inner join Payroll p on e.id=ed.employee.id and e.id = p.employee.id group by p.employee.id having max(p.salary)")
//    @Query("select e.fullName, max(p.salary) from Payroll p join Employee e on e.id=p.employee.id group by p.employee.id")
    @Query("select e.id,max(p.salary) from Employee e inner join EmploymentDetail ed on e.id=ed.employee.id and ed.startDate>=:now inner join Payroll p on p.employee.id=e.id and p.salary>=:lowerSalaryLimit group by e.id")
    List<Object[]> findAllByEmploymentDetail_StartDateAfterAndPayrolls(@Param("now") LocalDate now, @Param("lowerSalaryLimit") Double lowerSalaryLimit);

}
