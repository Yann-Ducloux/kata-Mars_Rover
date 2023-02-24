package model;

import exception.ObstacleException;

import java.util.Set;

public class Planet {
    int dimension;
    Set<Obstacle> obstacles;

    public Planet(int dimension, Set<Obstacle> obstacles) {
        this.dimension = dimension;
        this.obstacles = obstacles;
    }

    public boolean inUpperBorder(int y) {
        return (y == maxValue());
    }

    public boolean inLowerBorder(int y) {
        return (y == 0);
    }

    public int maxValue() {
        return dimension-1;
    }
    public void isObstacle(Position position){
        if (obstacles != null && this.obstacles.contains(new Obstacle(position.x, position.y))) {
            throw new ObstacleException(position.x, position.y);
        }
    }
}
