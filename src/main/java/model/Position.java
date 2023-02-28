package model;

import java.util.Objects;

/**
 * The Position
 *
 * @author Yann Ducloux
 * définit la position
 */
public class Position {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void forward(Direction direction, Planet planet) {
        switch (direction) {
            case N:
                yIncrease(planet);
                break;
            case S:
                yDecreases(planet);
                break;
            case E:
                xIncrease(planet);
                break;
            case W:
                xDecreases(planet);
                break;
        }
    }
    public void backward(Direction direction, Planet planet) {
        switch (direction) {
            case N:
                yDecreases(planet);
                break;
            case S:
                yIncrease(planet);
                break;
            case E:
                xDecreases(planet);
                break;
            case W:
                xIncrease(planet);
                break;
        }
    }

    private void xIncrease(Planet planet){
        this.x = (planet.inUpperBorder(this.x)) ? 0 : this.x+1;

    }

    private void xDecreases(Planet planet){
        this.x = (planet.inLowerBorder(this.x)) ? planet.maxValue() : this.x-1;
    }

    private void yIncrease(Planet planet){
       this.y = ((planet.inUpperBorder(this.y))) ? 0 : this.y+1;
    }

    private void yDecreases(Planet planet) {
        this.y = ((planet.inLowerBorder(this.y))) ? planet.maxValue() : this.y-1;
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
    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }
}