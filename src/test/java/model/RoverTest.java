package model;

import exception.CommandEmptyException;
import exception.LetterUnknownException;
import exception.NullCommandException;
import exception.ObstacleException;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoverTest {
  @Test
  void roverForwardNorth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.NORTH, planet(10))));
  }

  @Test
  void roverBackwardNorth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(5, 4), Direction.NORTH, planet(10))));
  }
  @Test
  void roverForwardAndBackwardNorth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("ffb");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.NORTH, planet(10))));
  }
  @Test
  void roverForwardSouth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.SOUTH, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(5, 4), Direction.SOUTH, planet(10))));
  }
  @Test
  void roverBackwardSouth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.SOUTH, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.SOUTH, planet(10))));
  }
  @Test
  void roverForwardAndBackwardSouth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.SOUTH, planet(10));

    //WHEN
    rover.execute("bbf");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.SOUTH, planet(10))));
  }
  @Test
  void roverForwardWest(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.WEST, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.WEST, planet(10))));
  }
  @Test
  void roverBackwardWest(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.WEST, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(6, 5), Direction.WEST, planet(10))));
  }
  @Test
  void roverForwardAndBackwardWest(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.WEST, planet(10));

    //WHEN
    rover.execute("fbf");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.WEST, planet(10))));
  }
  @Test
  void roverForwardEast(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.EAST, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(6, 5), Direction.EAST, planet(10))));
  }
  @Test
  void roverBackwardEast(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.EAST, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.EAST, planet(10))));
  }
  @Test
  void roverForwardAndBackwardEast(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.EAST, planet(10));

    //WHEN
    rover.execute("bfb");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.EAST, planet(10))));
  }

  @Test
  void roverLetterUnknown(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    assertThrows(LetterUnknownException.class, () -> {
      rover.execute("bfy");
    });

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.NORTH, planet(10))));
  }
  @Test
  void roverCommandNull(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    assertThrows(NullCommandException.class, () -> {
      rover.execute(null);
    });

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.NORTH, planet(10))));
  }

  @Test
  void roverCommandEmpty(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    assertThrows(CommandEmptyException.class, () -> {
      rover.execute("");
    });

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.NORTH, planet(10))));
  }

  @Test
  void roverTurnRight1Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("r");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.EAST, planet(10))));
  }
  @Test
  void roverTurnRight2Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("rr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.SOUTH, planet(10))));
  }
  @Test
  void roverTurnRight3Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("rrr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.WEST, planet(10))));
  }
  @Test
  void roverTurnRight4Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("rrrr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.NORTH, planet(10))));
  }

  @Test
  void roverTurnLeft1Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("l");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.WEST, planet(10))));
  }
  @Test
  void roverTurnLeft2Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("ll");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.SOUTH, planet(10))));
  }
  @Test
  void roverTurnLeft3Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("lll");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.EAST, planet(10))));
  }
  @Test
  void roverTurnLeft4Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("rrrr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.NORTH, planet(10))));
  }
  @Test
  void roverForwardNorthBorder(){
    //GIVEN
    Rover rover = new Rover(position(5,9), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(5, 0), Direction.NORTH, planet(10))));
  }
  @Test
  void roverBackwardNorthBorder(){
    //GIVEN
    Rover rover = new Rover(position(5,0), Direction.NORTH, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(5, 9), Direction.NORTH, planet(10))));
  }
  @Test
  void roverForwardSouthBorder(){
    //GIVEN
    Rover rover = new Rover(position(5,0), Direction.SOUTH, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(5, 9), Direction.SOUTH, planet(10))));
  }
  @Test
  void roverBackwardSouthBorder(){
    //GIVEN
    Rover rover = new Rover(position(5,9), Direction.SOUTH, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(5, 0), Direction.SOUTH, planet(10))));
  }

  @Test
  void roverForwardEastBorder(){
    //GIVEN
    Rover rover = new Rover(position(9,5), Direction.EAST, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(0, 5), Direction.EAST, planet(10))));
  }

  @Test
  void roverBackwardEastBorder(){
    //GIVEN
    Rover rover = new Rover(position(0,5), Direction.EAST, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(9, 5), Direction.EAST, planet(10))));
  }

  @Test
  void roverForwardWestBorder(){
    //GIVEN
    Rover rover = new Rover(position(0,5), Direction.WEST, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(9, 5), Direction.WEST, planet(10))));
  }

  @Test
  void roverBackwardWestBorder(){
    //GIVEN
    Rover rover = new Rover(position(9,5), Direction.WEST, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(0, 5), Direction.WEST, planet(10))));
  }

  @Test
  void roverTurnAndBackward(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.WEST, planet(10));

    //WHEN
    rover.execute("flf");

    //THEN
    assertThat(rover,is(rover(position(4, 4), Direction.SOUTH, planet(10))));
  }

  @Test
  void roverTurnAndForward(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.WEST, planet(10));

    //WHEN
    rover.execute("brb");

    //THEN
    assertThat(rover,is(rover(position(6, 4), Direction.NORTH, planet(10))));
  }

  @Test
  void roverContinueMoveAfterCorssTheBorderWest(){
    //GIVEN
    Rover rover = new Rover(position(9,5), Direction.WEST, planet(10));

    //WHEN
    rover.execute("brf");

    //THEN
    assertThat(rover,is(rover(position(0, 6), Direction.NORTH, planet(10))));
  }
  @Test
  void roverContinueMoveAfterCorssTheBorderSouth(){
    //GIVEN
    Rover rover = new Rover(position(5,0), Direction.SOUTH, planet(10));

    //WHEN
    rover.execute("flf");

    //THEN
    assertThat(rover,is(rover(position(6, 9), Direction.EAST, planet(10))));
  }
  @Test
  void roverForwardNorthObstacle(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10, obstacles(obstacle(5, 6))));

    //WHEN
    Exception exception = assertThrows(ObstacleException.class, () -> {
      rover.execute("f");
    });

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.NORTH, planet(10))));
    assertTrue(exception.getMessage().contains(messageError("The rover has encountered an obstacle in (5, 6)")));
  }
  @Test
  void roverBackwardNorthObstacle(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10, obstacles(obstacle(5, 4))));

    //WHEN
    Exception exception = assertThrows(ObstacleException.class, () -> {
      rover.execute("b");
    });

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.NORTH, planet(10))));
    assertTrue(exception.getMessage().contains(messageError("The rover has encountered an obstacle in (5, 4)")));
  }
  @Test
  void roverObstacleInCommands(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.NORTH, planet(10, obstacles(obstacle(2, 4))));

    //WHEN
    Exception exception = assertThrows(ObstacleException.class, () -> {
      rover.execute("bblfflbrffrrbb");
    });

    //THEN
    assertThat(rover,is(rover(position(3, 4), Direction.WEST, planet(10))));
    assertTrue(exception.getMessage().contains(messageError("The rover has encountered an obstacle in (2, 4)")));
  }
  @Test
  void roverMultipleObstaclesInCommands(){
    //GIVEN
    Rover rover = new Rover(position(0,0), Direction.NORTH, planet(10, obstacles(
            obstacle(2, 4), obstacle(1, 4), obstacle(0, 0))));

    //WHEN
    Exception exception = assertThrows(ObstacleException.class, () -> {
      rover.execute("lblbrrfffrbblff");
    });

    //THEN
    assertThat(rover,is(rover(position(1, 3), Direction.NORTH, planet(10))));
    assertTrue(exception.getMessage().contains(messageError("The rover has encountered an obstacle in (1, 4)")));
  }


  @Test
  void roverForwardEastBorderObstacle(){
    //GIVEN
    Rover rover = new Rover(position(8,5), Direction.EAST, planet(10, obstacles(obstacle(0, 5))));

    //WHEN
    Exception exception = assertThrows(ObstacleException.class, () -> {
      rover.execute("fff");
    });


    //THEN
    assertThat(rover,is(rover(position(9, 5), Direction.EAST, planet(10))));
    assertTrue(exception.getMessage().contains(messageError("The rover has encountered an obstacle in (0, 5)")));
  }
  private Position position(int x, int y) {
    return new Position(x, y);
  }
  private Rover rover(Position position, Direction direction, Planet planet) {
    return new Rover(position, direction, planet);
  }

  private Planet planet(int dimension) {
    return new Planet(dimension, Set.of());
  }

  private Planet planet(int dimension, Set<Obstacle> obstacles) {
    return new Planet(dimension, obstacles);
  }


  private Obstacle obstacle(int x, int y) {
    return new Obstacle(x, y);
  }

  private Set<Obstacle> obstacles(Obstacle... obstacles) {
    Set<Obstacle> obstacleSet = new HashSet<>();
    if(obstacles != null) {
        for (Obstacle obstacle: obstacles) {
          obstacleSet.add(obstacle);
        }
    }
    return obstacleSet;
  }


  private String messageError(String s) {
    return s;
  }
}