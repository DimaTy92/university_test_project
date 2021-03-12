package com.example.demo.controller;

import com.example.demo.entity.dto.DepartmentStatisticDto;
import com.example.demo.entity.dto.Response;
import com.example.demo.entity.type.Command;
import com.example.demo.parser.BracketsValueParser;
import com.example.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DepartmentController {

    private final BracketsValueParser parser;
    private final DepartmentService departmentService;

    public Response<String> getHeadOfDepartment(String incomingMessage) {
        String departmentName = parser.parserValueInBrackets(incomingMessage).trim();
        String headOfDepartment = departmentService.getHeadOfDepartment(departmentName);
        String outComingMessage = String.format(Command.HEAD_OF_DEPARTMENT.getOutComingMessagePaten(), departmentName, headOfDepartment);
        return new Response<>(outComingMessage);
    }

    public Response<String> getDepartmentStatistic(String incomingMessage) {
        String departmentName = parser.parserValueInBrackets(incomingMessage).trim();
        DepartmentStatisticDto statistic = departmentService.getDepartmentStatistic(departmentName);
        String outComingMessage = String.format(Command.DEPARTMENT_STATISTIC.getOutComingMessagePaten(),
                statistic.getAssistantCount(), statistic.getAssociateStatisticCount(), statistic.getProfessorCount());
        return new Response<>(outComingMessage);
    }

    public Response<String> getAverageSalaryOfTheDepartment(String incomingMessage) {
        String departmentName = parser.parserValueInBrackets(incomingMessage).trim();
        Double departmentAverageSalary = departmentService.getDepartmentAverageSalary(departmentName);
        String outComingMessage = String.format(Command.DEPARTMENT_AVERAGE_SALARY.getOutComingMessagePaten(), departmentName, departmentAverageSalary);
        return new Response<>(outComingMessage);
    }

    public Response<String> getCountOfEmployee(String incomingMessage) {
        String departmentName = parser.parserValueInBrackets(incomingMessage).trim();
        Integer departmentCountOfEmployee = departmentService.getDepartmentCountOfEmployee(departmentName);
        String outComingMessage = String.format(Command.COUNT_OF_EMPLOYEE.getOutComingMessagePaten(), departmentCountOfEmployee);
        return new Response<>(outComingMessage);
    }
}
