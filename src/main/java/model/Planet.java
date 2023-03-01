package model;

import exception.ObstacleException;

import java.util.Set;

public class Planet {
    private int dimension;
    private Set<Obstacle> obstacles;

    public Planet(int dimension, Set<Obstacle> obstacles) {
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
        if (obstacles != null && position.matchObstacle(this.obstacles)) {
            throw new ObstacleException(position);
        }
    }

    @Override
    public String toString() {
        return "Planet{" +
                "dimension=" + dimension +
                ", obstacles=" + obstacles +
                '}';
    }
}
