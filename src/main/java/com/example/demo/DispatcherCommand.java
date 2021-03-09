package com.example.demo;

import com.example.demo.entity.type.Command;

public interface DispatcherCommand {
    void dispatchCommand(Command command, String incomingMessage);

}
