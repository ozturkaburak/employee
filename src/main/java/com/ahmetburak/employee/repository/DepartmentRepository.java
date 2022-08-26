package com.ahmetburak.employee.repository;

import com.ahmetburak.employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
