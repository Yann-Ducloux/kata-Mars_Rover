package model;

import exception.CommandEmptyException;
import exception.LetterUnknownException;
import exception.NullCommandExecute;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoverTest {
  @Test
  void roverForwardNorth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.N, planet(10))));
  }

  @Test
  void roverBackwardNorth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(5, 4), Direction.N, planet(10))));
  }
  @Test
  void roverForwardAndBackwardNorth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    rover.execute("ffb");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.N, planet(10))));
  }
  @Test
  void roverForwardSouth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.S, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(5, 4), Direction.S, planet(10))));
  }
  @Test
  void roverBackwardSouth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.S, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.S, planet(10))));
  }
  @Test
  void roverForwardAndBackwardSouth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.S, planet(10));

    //WHEN
    rover.execute("bbf");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.S, planet(10))));
  }
  @Test
  void roverForwardWest(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.W, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.W, planet(10))));
  }
  @Test
  void roverBackwardWest(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.W, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(6, 5), Direction.W, planet(10))));
  }
  @Test
  void roverForwardAndBackwardWest(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.W, planet(10));

    //WHEN
    rover.execute("fbf");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.W, planet(10))));
  }
  @Test
  void roverForwardEast(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.E, planet(10));

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(6, 5), Direction.E, planet(10))));
  }
  @Test
  void roverBackwardEast(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.E, planet(10));

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.E, planet(10))));
  }
  @Test
  void roverForwardAndBackwardEast(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.E, planet(10));

    //WHEN
    rover.execute("bfb");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.E, planet(10))));
  }

  @Test
  void roverLetterUnknown(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    assertThrows(LetterUnknownException.class, () -> {
      rover.execute("bfy");
    });

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.N, planet(10))));
  }
  @Test
  void roverCommandNull(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    assertThrows(NullCommandExecute.class, () -> {
      rover.execute(null);
    });

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.N, planet(10))));
  }

  @Test
  void roverCommandEmpty(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    assertThrows(CommandEmptyException.class, () -> {
      rover.execute("");
    });

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.N, planet(10))));
  }

  @Test
  void roverTurnRight1Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    rover.execute("r");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.E, planet(10))));
  }
  @Test
  void roverTurnRight2Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    rover.execute("rr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.S, planet(10))));
  }
  @Test
  void roverTurnRight3Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    rover.execute("rrr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.W, planet(10))));
  }
  @Test
  void roverTurnRight4Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    rover.execute("rrrr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.N, planet(10))));
  }

  @Test
  void roverTurnLeft1Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    rover.execute("l");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.W, planet(10))));
  }
  @Test
  void roverTurnLeft2Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    rover.execute("ll");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.S, planet(10))));
  }
  @Test
  void roverTurnLeft3Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    rover.execute("lll");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.E, planet(10))));
  }
  @Test
  void roverTurnLeft4Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N, planet(10));

    //WHEN
    rover.execute("rrrr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.N, planet(10))));
  }

  private Position position(int x, int y) {
    return new Position(x, y);
  }
  private Rover rover(Position position, Direction direction, Planet planet) {
    return new Rover(position, direction, planet);
  }

  private Planet planet(int dimension) {
    return new Planet(dimension);
  }
}