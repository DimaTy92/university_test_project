package com.example.demo.service.impl;

import com.example.demo.entity.Department;
import com.example.demo.entity.dto.DepartmentStatisticDto;
import com.example.demo.entity.repository.DepartmentRepository;
import com.example.demo.entity.type.Degree;
import com.example.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private static final String NOT_FOUND = "not found";

    private final DepartmentRepository departmentRepository;

    @Override
    public String getHeadOfDepartment(String departmentName) {
        return departmentRepository.getDepartment(departmentName)
                .map(Department::getHeadOfDepartment)
                .orElse(NOT_FOUND);
    }

    @Override
    public DepartmentStatisticDto getDepartmentStatistic(String departmentName) {
        Integer assistantCount =
                departmentRepository.countLectorsInDepartmentByDegree(departmentName, Degree.ASSISTANT).orElse(0);
        Integer associateProfessorCount =
                departmentRepository.countLectorsInDepartmentByDegree(departmentName, Degree.ASSOCIATE_PROFESSOR).orElse(0);
        Integer professorCount =
                departmentRepository.countLectorsInDepartmentByDegree(departmentName, Degree.PROFESSOR).orElse(0);
        return new DepartmentStatisticDto(assistantCount, professorCount, associateProfessorCount);
    }

    @Override
    public Double getDepartmentAverageSalary(String departmentName) {
        return departmentRepository.departmentAverageSalary(departmentName).orElse(0d);
    }

    @Override
    public Integer getDepartmentCountOfEmployee(String departmentName) {
        return departmentRepository.countOfEmployee(departmentName).orElse(0);
    }

}
