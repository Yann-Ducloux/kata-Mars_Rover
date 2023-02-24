package model;

import java.util.Objects;

/**
 * The Position
 *
 * @author Yann Ducloux
 * définit la position
 */
public class Position {
    int x;
    int y;

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

    public void xIncrease(Planet planet){
        if(planet.inUpperBorder(this.x)) {
            this.x = 0;
        } else {
            this.x++;
        }
    }

    public void xDecreases(Planet planet){
        if(planet.inLowerBorder(this.x)) {
            this.x = planet.maxValue();
        } else {
            this.x--;
        }
    }

    public void yIncrease(Planet planet){
        if(planet.inUpperBorder(this.y)) {
            this.y = 0;
        } else {
            this.y++;
        }
    }

    public void yDecreases(Planet planet) {
        if (planet.inLowerBorder(this.y)) {
            this.y = planet.maxValue();
        } else {
            this.y--;
        }
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