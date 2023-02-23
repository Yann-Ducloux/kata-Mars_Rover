package model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rover {
    private Position position;
    private Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void forward() {
        this.position.forward(this.direction);
    }

    public void backward() {
       this.position.backward(this.direction);
    }

    public List<Command> receiveCommands(String commands){;
        return Command.transcription(commands);
    }

    public void execute(String commandStrings) {
        List<Command> commands = receiveCommands(commandStrings);
        for (Command command : commands) {
            switch (command) {
                case f:
                    forward();
                    break;
                case b:
                    backward();
                    break;
            }
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(position, rover.position) && direction == rover.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
