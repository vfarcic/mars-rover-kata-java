package com.technologyconversations.kata.marsrover;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/*
Source: http://dallashackclub.com/rover

Develop an api that moves a rover around on a grid.
* You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
* The rover receives a character array of commands.
* Implement commands that move the rover forward/backward (f,b).
* Implement commands that turn the rover left/right (l,r).
* Implement wrapping from one edge of the grid to another. (planets are spheres after all)
* Implement obstacle detection before each move to a new square.
If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle.
*/
public class RoverSpec {

    // TODO Move backward
    // TODO Obstacle detection

    private Rover rover;
    private Coordinates roverCoordinates;
    private final Direction direction = Direction.NORTH;
    private final int x = 1;
    private final int y = 2;
    private final int maxX = 9;

    @Before
    public void beforeRoverTest() {
        roverCoordinates = new Coordinates(x, y, maxX, 9);
        rover = new Rover(roverCoordinates, direction);
    }

    @Test
    public void newInstanceShouldSetRoverCoordinatesAndDirection() {
        assertThat(rover.getCoordinates()).isEqualToComparingFieldByField(roverCoordinates);
        assertThat(rover.getDirection()).isEqualTo(direction);
    }

    @Test
    public void receiveSingleCommandShouldMoveForwardWhenCommandIsM() throws Exception {
        rover.receiveSingleCommand('M');
        assertThat(rover.getCoordinates().getY().getLocation()).isEqualTo(y + 1);
    }

    @Test
    public void receiveSingleCommandShouldTurnLeftWhenCommandIsL() throws Exception {
        rover.receiveSingleCommand('L');
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void receiveSingleCommandShouldTurnRightWhenCommandIsR() throws Exception {
        rover.receiveSingleCommand('R');
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test(expected = Exception.class)
    public void receiveSingleCommandShouldThrowExceptionWhenCommandIsUnknown() throws Exception {
        rover.receiveSingleCommand('X');
    }

    @Test
    public void receiveCommandsShouldBeAbleToReceiveMultipleCommands() throws Exception {
        rover.receiveCommands("RMR");
        assertThat(rover.getCoordinates().getX().getLocation()).isEqualTo(x + 1);
        assertThat(rover.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void receiveCommandShouldWhatFromOneEdgeOfTheGridToAnother() throws Exception {
        rover.receiveCommands("LMMM");
        assertThat(rover.getCoordinates().getX().getLocation()).isEqualTo(maxX + x - 2);
    }

    @Test
    public void positionShouldReturnXYAndDirection() throws Exception {
        rover.receiveCommands("LMMMRMM");
        assertThat(rover.getPosition()).isEqualTo("8 X 4 N");
    }


}