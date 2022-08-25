package com.ahmetburak.employee.repository;

import com.ahmetburak.employee.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

    List<Payroll> findAllByEmployee_Id(Long userId);



}
