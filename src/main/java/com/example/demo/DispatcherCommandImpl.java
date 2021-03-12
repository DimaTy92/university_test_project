package com.example.demo;

import com.example.demo.controller.DepartmentController;
import com.example.demo.controller.LectorController;
import com.example.demo.entity.dto.Response;
import com.example.demo.entity.type.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DispatcherCommandImpl implements DispatcherCommand {
    private static final String COMMAND_NOT_FOUND = "Command not found";

    private final LectorController lectorController;
    private final DepartmentController departmentController;

    @Override
    public void dispatchCommand(Command command, String incomingMessage) {
        Response response;
        switch (command) {
            case HEAD_OF_DEPARTMENT:
                response = departmentController.getHeadOfDepartment(incomingMessage);
                break;
            case DEPARTMENT_STATISTIC:
                response = departmentController.getDepartmentStatistic(incomingMessage);
                break;
            case DEPARTMENT_AVERAGE_SALARY:
                response = departmentController.getAverageSalaryOfTheDepartment(incomingMessage);
                break;
            case COUNT_OF_EMPLOYEE:
                response = departmentController.getCountOfEmployee(incomingMessage);
                break;
            case GLOBAL_SEARCH:
                response = lectorController.createGlobalSearch(incomingMessage);
                break;
            default:
                response = getNotFoundCommandResponse();
                break;
        }
        System.out.println(response.getResponse());
    }

    private Response<String> getNotFoundCommandResponse() {
        return new Response<>(COMMAND_NOT_FOUND);
    }
}

