package model;

public class Obstacle extends Coordinate{

    public Obstacle(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Obstacle obstacle = (Obstacle) o;

        if (x != obstacle.x) return false;
        return y == obstacle.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
