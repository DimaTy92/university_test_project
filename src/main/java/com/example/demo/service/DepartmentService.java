package com.example.demo.service;

import com.example.demo.entity.dto.DepartmentStatisticDto;

public interface DepartmentService {
    String getHeadOfDepartment(String departmentName);

    DepartmentStatisticDto getDepartmentStatistic(String departmentName);

    Double getDepartmentAverageSalary(String departmentName);

    Integer getDepartmentCountOfEmployee(String departmentName);
}

