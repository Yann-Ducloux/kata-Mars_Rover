package model;

import java.util.List;
import java.util.Objects;

public class Rover {
    private Position position;
    private Direction direction;
    private Planet planet;

    public Rover(Position position, Direction direction, Planet planet) {
        this.position = position;
        this.direction = direction;
        this.planet = planet;
    }

    public void forward() {
        this.position.forward(this.direction, this.planet);
    }
    public void backward() {
       this.position.backward(this.direction, this.planet);
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }
    public List<Command> receiveCommands(String commands) {
        return Command.transcription(commands);
    }
    public void execute(String commandStrings) {
        List<Command> commands = receiveCommands(commandStrings);
        executeCommands(commands);
    }

    public void executeCommands(List<Command> commands) {
        for (Command command : commands) {
            switch (command) {
                case f:
                    detectionObstacleForward();
                    forward();
                    break;
                case b:
                    detectionObstacleBackward();
                    backward();
                    break;
                case r:
                    turnRight();
                    break;
                case l:
                    turnLeft();
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
    public void detectionObstacleForward(){
        Position positionCopy = new Position(this.position);
        positionCopy.forward(this.direction, this.planet);
        planet.isObstacle(positionCopy);
    }
    public void detectionObstacleBackward() {
        Position positionCopy = new Position(this.position);
        positionCopy.backward(this.direction, this.planet);
        planet.isObstacle(positionCopy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
