package model;

public class Planet {
    private int dimension;

    public Planet(int dimension) {
        this.dimension = dimension;
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
