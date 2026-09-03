package com.jurisai.Visual;


import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private final List<Command> history = new ArrayList<>();

    public void runCommand(Command command) {
        command.execute();
        history.add(command);
    }
}