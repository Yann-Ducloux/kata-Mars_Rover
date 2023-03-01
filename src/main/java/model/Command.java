package model;

import exception.CommandEmptyException;
import exception.LetterUnknownException;
import exception.NullCommandException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Command {
    /**
     * Forward
     */
    f,
    /**
     * Backward
     */
    b,
    /**
     * Right
     */
    r,
    /**
     * Left
     */
    l;
    Command(){}
    private static final String EMPTY_FIELD = "";

    public static List<Command> transcription(String commands) {
        if(commands == null) {
            throw new NullCommandException();
        }
        if(commands.isEmpty()) {
            throw new CommandEmptyException();
        }
        try {
            return Stream.of(commands.split(EMPTY_FIELD))
                    .map(Command::valueOf)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new LetterUnknownException();
        }
    }
}
