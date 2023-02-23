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
    public void forward(Direction direction) {
        switch (direction) {
            case N:
                this.y++;
                break;
            case S:
                this.y--;
                break;
            case E:
                this.x++;
                break;
            case W:
                this.x--;
                break;
        }
    }
    public void backward(Direction direction) {
        switch (direction) {
            case N:
                this.y--;
                break;
            case S:
                this.y++;
                break;
            case E:
                this.x--;
                break;
            case W:
                this.x++;
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