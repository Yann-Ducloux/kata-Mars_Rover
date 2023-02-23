package model;

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
    b;
    Command(){}
    private static final String EMPTY_FIELD = "";

    public static List<Command> transcription(String commands) {
        return Stream.of(commands.split(EMPTY_FIELD))
                .map(Command::valueOf)
                .collect(Collectors.toList());
    }
}
