package com.ahmetburak.employee.service;

import com.ahmetburak.employee.dto.DepartmentDTO;
import com.ahmetburak.employee.dto.EmployeeDTO;
import com.ahmetburak.employee.dto.EmploymentDetailDTO;
import com.ahmetburak.employee.dto.OfficeDTO;
import com.ahmetburak.employee.entity.EmploymentDetail;
import com.ahmetburak.employee.entity.Office;
import com.ahmetburak.employee.mapper.EmploymentDetailMapper;
import com.ahmetburak.employee.repository.EmploymentDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by ahmetburakozturk on 24.08.2022
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class EmploymentDetailService {

    private final EmployeeService employeeService;

    private final DepartmentService departmentService;

    private final OfficeService officeService;
    private final EmploymentDetailMapper employmentDetailMapper;
    private final EmploymentDetailRepository employmentDetailRepository;

    public EmploymentDetailDTO saveOrUpdate(EmploymentDetailDTO employmentDetailDTO) {
        OfficeDTO officeDTO = officeService.findById(Objects.requireNonNull(employmentDetailDTO.getOffice().getId()));
        EmployeeDTO employeeDTO = employeeService.findById(Objects.requireNonNull(employmentDetailDTO.getEmployee().getId()));
        DepartmentDTO departmentDTO = departmentService.findById(Objects.requireNonNull(employmentDetailDTO.getDepartment().getId()));

        employmentDetailDTO.setEmployee(employeeDTO);
        employmentDetailDTO.setDepartment(departmentDTO);
        employmentDetailDTO.setOffice(officeDTO);

        EmploymentDetail employmentDetail = employmentDetailMapper.toEntity(employmentDetailDTO);
        employmentDetail = employmentDetailRepository.save(employmentDetail);
        return employmentDetailMapper.toDTO(employmentDetail);
    }

    //
    public void deleteById(Long employmentDetailId) {
        employmentDetailRepository.deleteById(employmentDetailId);
    }

    public EmploymentDetailDTO findById(Long employmentDetailId) {
        Optional<EmploymentDetail> byId = employmentDetailRepository.findById(employmentDetailId);
        return byId.map(employmentDetailMapper::toDTO).orElse(null);
    }

    public List<EmploymentDetailDTO> findAllByEmployeeId(Integer pageNo, Integer pageSize, Long employeeId) {
        final Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
        List<EmploymentDetail> employmentDetailList = employmentDetailRepository.findAllByEmployee_Id(employeeId, paging);
        return employmentDetailList.stream().map(employmentDetailMapper::toDTO).toList();
    }

    public void updateOfficeLocationByDepartmentId(Long officeId, Long departmentId) {
        List<EmploymentDetail> allByDepartments = employmentDetailRepository.findAllByDepartment_Id(departmentId);
        Office entityById = officeService.findEntityById(officeId);
        if (Objects.nonNull(entityById)) {
            allByDepartments.forEach(employmentDetail -> employmentDetail.setOffice(entityById));
        }
        employmentDetailRepository.saveAll(allByDepartments);
    }
}
