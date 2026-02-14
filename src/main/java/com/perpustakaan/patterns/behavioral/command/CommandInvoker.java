package com.perpustakaan.patterns.behavioral.command;

import java.util.Stack;

public class CommandInvoker {

    private Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
        }
    }
}
