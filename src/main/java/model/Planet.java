package model;

import java.util.Set;

public class Planet {
    int dimension;
    Set<Obstacle> obstacles;

    public Planet(int dimension, Set<Obstacle> obstacles) {
        this.dimension = dimension;
        this.obstacles = obstacles;
    }

    public boolean inUpperBorder(int y) {
        return (y == border());
    }

    public boolean inLowerBorder(int y) {
        return (y == 0);
    }

    public int border() {
        return dimension-1;
    }
}
