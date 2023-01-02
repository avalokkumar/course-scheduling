package com.example.geektrust.util;


import java.util.Arrays;

public enum Command {

    ADD_COURSE_OFFERING("ADD-COURSE-OFFERING"),
    REGISTER("REGISTER"),
    ALLOT("ALLOT"),
    CANCEL("CANCEL"),

    VIEW("VIEW");


    final String commandName;

    Command(String commandName) {
        this.commandName = commandName;
    }

    public static boolean isValidCommand(String commandName) {
        return Arrays.stream(Command.values()).anyMatch(command -> command.commandName.equals(commandName));
    }

    public static Command getCommand(String commandName) {
        return Arrays.stream(Command.values()).filter(command -> command.commandName.equals(commandName)).findFirst().orElse(null);
    }
}
