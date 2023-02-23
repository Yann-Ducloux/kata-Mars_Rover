package exception;

public class ObstacleException extends RuntimeException {
    public ObstacleException(int x, int y) {
        super("The rover has encountered an obstacle in (" + x + ", " + y + ")") ;
    }
}