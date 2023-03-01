package model;

import exception.ObstacleException;

import java.util.List;
import java.util.Set;

public class Planet {
    private int dimension;
    private List<Obstacle> obstacles;

    public Planet(int dimension, List<Obstacle> obstacles) {
        this.dimension = dimension;
        this.obstacles = obstacles;
    }

    public boolean inUpperBorder(int value) {
        return (value == maxValue());
    }

    public boolean inLowerBorder(int value) {
        return (value == 0);
    }

    public int maxValue() {
        return dimension-1;
    }
    public void isObstacle(Position position){
        if (obstacles != null && this.obstacles.contains(new Obstacle(position.getX(), position.getY()))) {
            throw new ObstacleException(position);
        }
    }
}
