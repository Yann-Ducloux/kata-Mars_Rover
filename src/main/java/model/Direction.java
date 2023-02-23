package model;

public enum Direction {

    /**
     * North
     */
    N(){
        @Override
        public Direction turnRight() {
            return Direction.E;
        }

        @Override
        public Direction turnLeft() {
            return Direction.W;
        }
    },
    /**
     * South
     */
    S(){
        @Override
        public Direction turnRight() {
            return Direction.W;
        }

        @Override
        public Direction turnLeft() {
            return Direction.E;
        }
    },

    /**
     * East
     */
    E(){
        @Override
        public Direction turnRight() {
            return Direction.S;
        }

        @Override
        public Direction turnLeft() {
            return Direction.N;
        }
    },
    /**
     * West
     */
    W(){
        @Override
        public Direction turnRight() {
            return Direction.N;
        }

        @Override
        public Direction turnLeft() {
            return Direction.S;
        }
    };
    public abstract  Direction turnRight();
    public abstract  Direction turnLeft();

}
