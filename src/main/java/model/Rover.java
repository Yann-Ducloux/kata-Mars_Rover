package model;

import java.util.List;
import java.util.Objects;

public class Rover {
    private Position position;
    private Direction direction;
    private final Planet planet;

    public Rover(Position position, Direction direction, Planet planet) {
        this.position = position;
        this.direction = direction;
        this.planet = planet;
    }

    private void turnRight() {
        this.direction = this.direction.turnRight();
    }

    private void turnLeft() {
        this.direction = this.direction.turnLeft();
    }
    private List<Command> receiveCommands(String commands) {
        return Command.transcription(commands);
    }
    public void execute(String commandStrings) {
        List<Command> commands = receiveCommands(commandStrings);
        executeCommands(commands);
    }

    private void executeCommands(List<Command> commands) {
        for (Command command : commands) {
            switch (command) {
                case FORWARD  -> detectAndMove(this.position.forward(this.direction, this.planet));
                case BACKWARD -> detectAndMove(this.position.backward(this.direction, this.planet));
                case RIGHT    -> turnRight();
                case LEFT     -> turnLeft();
            }
        }
    }

    private void detectAndMove(Position position) {
        detectObstacle(position);
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(position, rover.position) && direction == rover.direction;
    }

    private void detectObstacle(Position nextPosition) {
        planet.obstacleInCoordinate(nextPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", direction=" + direction +
                ", planet=" + planet +
                '}';
    }
}
