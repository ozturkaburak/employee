package com.ahmetburak.employee.repository;

import com.ahmetburak.employee.entity.EmploymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@Repository
public interface EmploymentRepository extends JpaRepository<EmploymentDetail,Long> {
}
