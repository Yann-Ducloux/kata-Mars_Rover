package model;

import exception.CommandEmptyException;
import exception.LetterUnknownException;
import exception.NullCommandException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Command {
    FORWARD("f"),
    BACKWARD("b"),
    RIGHT("r"),
    LEFT("l");
    private static final String EMPTY_FIELD = "";
    private final String instruction;

    Command(String instruction) {
        this.instruction = instruction;
    }

    public static List<Command> transcription(String commands) {
        if(commands == null) {
            throw new NullCommandException();
        }
        if(commands.isEmpty()) {
            throw new CommandEmptyException();
        }
        return Stream.of(commands.split(EMPTY_FIELD))
                .map(Command::convertToCommand)
                .collect(Collectors.toList());
    }

    private static Command convertToCommand(String instruction) {
        for (Command command : Command.values()) {
            if (command.instruction.equalsIgnoreCase(instruction)) {
                return command;
            }
        }
        throw new LetterUnknownException();
    }
}
