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
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.N)));
  }
  @Test
  void roverBackwardNorth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(5, 4), Direction.N)));
  }
  @Test
  void roverForwardAndBackwardNorth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    rover.execute("ffb");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.N)));
  }
  @Test
  void roverForwardSouth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.S);

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(5, 4), Direction.S)));
  }
  @Test
  void roverBackwardSouth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.S);

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.S)));
  }
  @Test
  void roverForwardAndBackwardSouth(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.S);

    //WHEN
    rover.execute("bbf");

    //THEN
    assertThat(rover,is(rover(position(5, 6), Direction.S)));
  }
  @Test
  void roverForwardWest(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.W);

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.W)));
  }
  @Test
  void roverBackwardWest(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.W);

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(6, 5), Direction.W)));
  }
  @Test
  void roverForwardAndBackwardWest(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.W);

    //WHEN
    rover.execute("fbf");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.W)));
  }
  @Test
  void roverForwardEast(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.E);

    //WHEN
    rover.execute("f");

    //THEN
    assertThat(rover,is(rover(position(6, 5), Direction.E)));
  }
  @Test
  void roverBackwardEast(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.E);

    //WHEN
    rover.execute("b");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.E)));
  }
  @Test
  void roverForwardAndBackwardEast(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.E);

    //WHEN
    rover.execute("bfb");

    //THEN
    assertThat(rover,is(rover(position(4, 5), Direction.E)));
  }

  @Test
  void roverLetterUnknown(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    assertThrows(LetterUnknownException.class, () -> {
      rover.execute("bfy");
    });

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.N)));
  }
  @Test
  void roverCommandNull(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    assertThrows(NullCommandExecute.class, () -> {
      rover.execute(null);
    });

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.N)));
  }

  @Test
  void roverCommandEmpty(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    assertThrows(CommandEmptyException.class, () -> {
      rover.execute("");
    });

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.N)));
  }

  @Test
  void roverTurnRight1Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    rover.execute("r");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.E)));
  }
  @Test
  void roverTurnRight2Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    rover.execute("rr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.S)));
  }
  @Test
  void roverTurnRight3Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    rover.execute("rrr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.W)));
  }
  @Test
  void roverTurnRight4Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    rover.execute("rrrr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.N)));
  }

  @Test
  void roverTurnLeft1Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    rover.execute("l");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.W)));
  }
  @Test
  void roverTurnLeft2Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    rover.execute("ll");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.S)));
  }
  @Test
  void roverTurnLeft3Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    rover.execute("lll");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.E)));
  }
  @Test
  void roverTurnLeft4Time(){
    //GIVEN
    Rover rover = new Rover(position(5,5), Direction.N);

    //WHEN
    rover.execute("rrrr");

    //THEN
    assertThat(rover,is(rover(position(5, 5), Direction.N)));
  }

  private Position position(int x, int y) {
    return new Position(x, y);
  }
  private Rover rover(Position position, Direction direction) {
    return new Rover(position, direction);
  }
}