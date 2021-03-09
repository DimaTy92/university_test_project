package com.example.demo;

import com.example.demo.entity.type.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class UniversityTestProjectApplication {
    private static final String EXIT = "EXIT";

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(UniversityTestProjectApplication.class, args);
        DispatcherCommand dispatcherCommand = applicationContext.getBean(DispatcherCommand.class);

        String incomingMessage;

        do {
            Scanner in = new Scanner(System.in);
            System.out.println("What would you like to ask?");
            incomingMessage = in.nextLine();
            if (Objects.nonNull(incomingMessage) && !incomingMessage.equals(EXIT)) {
                Command command = Command.getCommand(incomingMessage);
                dispatcherCommand.dispatchCommand(command, incomingMessage);
            }
        } while (!incomingMessage.equals(EXIT));


    }

}
