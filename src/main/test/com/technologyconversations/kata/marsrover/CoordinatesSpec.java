package com.technologyconversations.kata.marsrover;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CoordinatesSpec {

    private Coordinates coordinates;
    private Point x;
    private Point y;
    private List<Obstacle> obstacles;
    private final Direction direction = Direction.NORTH;

    @Before
    public void beforeCoordinatesTest() {
        x = new Point(1, 99);
        y = new Point(2, 99);
        obstacles = Arrays.asList(new Obstacle(20, 20), new Obstacle(30, 30));
        coordinates = new Coordinates(x, y, direction);
    }

    @Test
    public void newInstanceShouldSetXAndYParams() {
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(x);
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(y);
    }

    @Test
    public void newInstanceShouldSetDirection() {
        assertThat(coordinates.getDirection()).isEqualTo(direction);
    }

//    @Test
//    public void newInstanceShouldSetDirection() {
//        assertThat()
//    }

    @Test
    public void moveForwardShouldIncreaseYWhenDirectionIsNorth() {
        Point expected = new Point(y.getLocation() + 1, y.getMaxLocation());
        coordinates.setDirection(Direction.NORTH);
        coordinates.moveForward();
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveForwardShouldIncreaseXWhenDirectionIsEast() {
        Point expected = new Point(x.getLocation() + 1, x.getMaxLocation());
        coordinates.setDirection(Direction.EAST);
        coordinates.moveForward();
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveForwardShouldDecreaseYWhenDirectionIsSouth() {
        Point expected = new Point(y.getLocation() - 1, y.getMaxLocation());
        coordinates.setDirection(Direction.SOUTH);
        coordinates.moveForward();
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveForwardShouldDecreaseXWhenDirectionIsWest() {
        Point expected = new Point(x.getLocation() - 1, x.getMaxLocation());
        coordinates.setDirection(Direction.WEST);
        coordinates.moveForward();
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveBackwardShouldDecreaseYWhenDirectionIsNorth() {
        Point expected = new Point(y.getLocation() - 1, y.getMaxLocation());
        coordinates.setDirection(Direction.NORTH);
        coordinates.moveBackward();
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveBackwardShouldDecreaseXWhenDirectionIsEast() {
        Point expected = new Point(x.getLocation() - 1, x.getMaxLocation());
        coordinates.setDirection(Direction.EAST);
        coordinates.moveBackward();
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveBackwardShouldIncreaseYWhenDirectionIsSouth() {
        Point expected = new Point(y.getLocation() + 1, y.getMaxLocation());
        coordinates.setDirection(Direction.SOUTH);
        coordinates.moveBackward();
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveBackwardShouldIncreaseXWhenDirectionIsWest() {
        Point expected = new Point(x.getLocation() + 1, x.getMaxLocation());
        coordinates.setDirection(Direction.WEST);
        coordinates.moveBackward();
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void toStringShouldReturnXAndY() {
        String expected = x.getLocation() + " X " + y.getLocation() + " " + direction.getShortName();
        assertThat(coordinates.toString()).isEqualTo(expected);
    }

}