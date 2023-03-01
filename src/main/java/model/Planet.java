package model;

import exception.ObstacleException;

import java.util.Set;

public class Planet {
    private final int dimension;
    private final Set<Obstacle> obstacles;

    public Planet(int dimension, Set<Obstacle> obstacles) {
        this.dimension = dimension;
        this.obstacles = obstacles;
    }

    public boolean coordinateInUpperBorder(int value) {
        return (value == maxValue());
    }

    public boolean coordinateInLowerBorder(int value) {
        return (value == 0);
    }

    public int maxValue() {
        return dimension-1;
    }
    public void obstacleInCoordinate(Position position){
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
