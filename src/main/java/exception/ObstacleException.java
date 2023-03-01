package exception;

import model.Position;

public class ObstacleException extends RuntimeException {
    public ObstacleException(Position position) {
        super("The rover has encountered an obstacle in " + position.toString()) ;
    }
}