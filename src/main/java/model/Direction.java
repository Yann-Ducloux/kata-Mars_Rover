package model;

public enum Direction {

    NORTH(){
        @Override
        public Direction turnRight() {
            return Direction.EAST;
        }

        @Override
        public Direction turnLeft() {
            return Direction.WEST;
        }
    },
    SOUTH(){
        @Override
        public Direction turnRight() {
            return Direction.WEST;
        }

        @Override
        public Direction turnLeft() {
            return Direction.EAST;
        }
    },

    EAST(){
        @Override
        public Direction turnRight() {
            return Direction.SOUTH;
        }

        @Override
        public Direction turnLeft() {
            return Direction.NORTH;
        }
    },
    WEST(){
        @Override
        public Direction turnRight() {
            return Direction.NORTH;
        }

        @Override
        public Direction turnLeft() {
            return Direction.SOUTH;
        }
    };
    public abstract  Direction turnRight();
    public abstract  Direction turnLeft();

}
