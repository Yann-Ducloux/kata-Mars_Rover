package model;

import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class Position extends Coordinate {

    public Position(int x, int y) {
        super(x, y);
    }

    public Position forward(Direction direction, Planet planet) {
        switch (direction) {
            case NORTH:
                return yIncrease(planet);
            case SOUTH:
                return yDecreases(planet);
            case EAST:
                return xIncrease(planet);
            case WEST:
                return xDecreases(planet);
            default:
                throw new RuntimeException("this was not supposed to happen");
        }
    }
    public Position backward(Direction direction, Planet planet) {
        switch (direction) {
            case NORTH:
                return yDecreases(planet);
            case SOUTH:
                return yIncrease(planet);
            case EAST:
                return xDecreases(planet);
            case WEST:
                return xIncrease(planet);
            default:
                throw new RuntimeException("this was not supposed to happen");
        }
    }

    private Position xIncrease(Planet planet){
        return planet.coordinateInUpperBorder(this.x) ? new Position(0, this.y) : new Position(this.x+1, this.y);
    }

    private Position xDecreases(Planet planet){
        return planet.coordinateInLowerBorder(this.x) ? new Position(planet.maxValue(), this.y) : new Position(this.x-1, this.y);
    }

    private Position yIncrease(Planet planet){
       return planet.coordinateInUpperBorder(this.y) ? new Position(this.x, 0) : new Position(x,this.y+1);
    }

    private Position yDecreases(Planet planet) {
        return planet.coordinateInLowerBorder(this.y) ? new Position(this.x, planet.maxValue()) : new Position(this.x, this.y-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

    public boolean matchObstacle(Set<Obstacle> obstacles) {
        return obstacles.stream().anyMatch(sameCoordinate());
    }

    private Predicate<Obstacle> sameCoordinate() {
        return obstacle -> Objects.equals(this.x, obstacle.x) && Objects.equals(this.y, obstacle.y);
    }
}