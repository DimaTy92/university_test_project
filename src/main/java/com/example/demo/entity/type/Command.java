package com.example.demo.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Command {
    HEAD_OF_DEPARTMENT(Collections.singletonList("Who is head of department"),
            "Head of %s department is %s"),
    DEPARTMENT_STATISTIC(List.of("Show", "statistics"), "assistans - %s,\n" +
            " associate professors - %s,\n" +
            " professors - %s"),
    DEPARTMENT_AVERAGE_SALARY(Collections.singletonList("Show the average salary for the department"),
            "The average salary of %s is %f"),
    COUNT_OF_EMPLOYEE(Collections.singletonList("Show count of employee for"), "%d"),

    GLOBAL_SEARCH(Collections.singletonList("Global search by"), "%s"),

    COMMAND_NOT_FOUND(Collections.emptyList(), null);

    private List<String> commandParts;
    private String outComingMessagePaten;


    public static Command getCommand(String incomingMessage) {
        for (Command command : Command.values()) {
            if (Objects.nonNull(incomingMessage) &&
                    containsAll(command.getCommandParts(), incomingMessage)) {
                return command;
            }
        }
        return COMMAND_NOT_FOUND;
    }

    private static boolean containsAll(List<String> patterns, String incomingMessage) {
        return patterns.stream()
                .allMatch(stringPart -> incomingMessage.toLowerCase().contains(stringPart.toLowerCase()));
    }

}
