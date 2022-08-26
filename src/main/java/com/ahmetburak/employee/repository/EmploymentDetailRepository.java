package com.ahmetburak.employee.repository;

import com.ahmetburak.employee.entity.EmploymentDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ahmetburakozturk on 25.08.2022
 **/
@Repository
public interface EmploymentDetailRepository extends JpaRepository<EmploymentDetail, Long> {

    List<EmploymentDetail> findAllByEmployee_Id(@Param("employeeId") Long employeeId, Pageable pageable);

    List<EmploymentDetail> findAllByDepartment_Id(Long departmentId);

}
