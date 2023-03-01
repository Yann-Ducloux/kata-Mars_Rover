package model;

import java.util.Objects;

/**
 * The Position
 *
 * @author Yann Ducloux
 * définit la position
 */
public class Position extends Coordinate {

    public Position(int x, int y) {
        super(x, y);
    }
    public Position(Position position) {
        super(position.getX(), position.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position forward(Direction direction, Planet planet) {
        switch (direction) {
            case N:
                return yIncrease(planet);
            case S:
                return yDecreases(planet);
            case E:
                return xIncrease(planet);
            case W:
                return xDecreases(planet);
            default:
                throw new RuntimeException();
        }
    }
    public Position backward(Direction direction, Planet planet) {
        switch (direction) {
            case N:
                return yDecreases(planet);
            case S:
                return yIncrease(planet);
            case E:
                return xDecreases(planet);
            case W:
                return xIncrease(planet);
            default:
                throw new RuntimeException();
        }
    }

    private Position xIncrease(Planet planet){
        return planet.inUpperBorder(this.x) ? new Position(0, this.y) : new Position(this.x+1, this.y);
    }

    private Position xDecreases(Planet planet){
        return planet.inLowerBorder(this.x) ? new Position(planet.maxValue(), this.y) : new Position(this.x-1, this.y);
    }

    private Position yIncrease(Planet planet){
       return planet.inUpperBorder(this.y) ? new Position(this.x, 0) : new Position(x,this.y+1);
    }

    private Position yDecreases(Planet planet) {
        return planet.inLowerBorder(this.y) ? new Position(this.x, planet.maxValue()) : new Position(this.x, this.y-1);
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
}