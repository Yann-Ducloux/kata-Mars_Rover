package model;

import exception.ObstacleException;

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
        if(planet.obstacles!= null) {
            throw new ObstacleException(5, 6);
        }
        switch (direction) {
            case N:
                if(planet.inUpperBorder(y)) {
                    this.y=0;
                } else {
                    this.y++;
                }
                break;
            case S:
                if(planet.inLowerBorder(y)) {
                    this.y = planet.border();
                } else {
                    this.y--;
                }
                break;
            case E:
                if(planet.inUpperBorder(x)) {
                    this.x=0;
                } else {
                    this.x++;
                }
                break;
            case W:
                if(planet.inLowerBorder(x)) {
                    this.x=planet.border();
                } else {
                    this.x--;
                }
                break;
        }
    }
    public void backward(Direction direction, Planet planet) {
        switch (direction) {
            case N:
                if(planet.inLowerBorder(y)) {
                    this.y= planet.border();
                } else {
                    this.y--;
                }
                break;
            case S:
                if(planet.inUpperBorder(y)) {
                    this.y= 0;
                } else {
                    this.y++;
                }
                break;
            case E:
                if(planet.inLowerBorder(x)) {
                    this.x= planet.border();
                } else {
                    this.x--;
                }
                break;
            case W:
                if(planet.inUpperBorder(x)) {
                    this.x = 0;
                } else {
                    this.x++;
                }
                break;
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
}