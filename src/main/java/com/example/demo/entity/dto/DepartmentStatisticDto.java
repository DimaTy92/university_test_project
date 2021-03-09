package com.example.demo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DepartmentStatisticDto {
    private Integer assistantCount;
    private Integer professorCount;
    private Integer associateStatisticCount;
}
