package com.ahmetburak.employee.repository;

import com.ahmetburak.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ahmetburakozturk on 23.08.2022
 **/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
