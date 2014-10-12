package com.technologyconversations.kata.marsrover;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CoordinatesSpec {

    private Coordinates coordinates;
    private final int maxLocation = 99;
    private final int x = 1;
    private final int y = 2;

    @Before
    public void beforeCoordinatesTest() {
        coordinates = new Coordinates(x, y, maxLocation, maxLocation);
    }

    @Test
    public void newInstanceShouldSetXAndYParams() {
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(new Point(x, maxLocation));
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(new Point(y, maxLocation));
    }

    @Test
    public void moveShouldIncreaseYWhenDirectionIsNorth() {
        Point expected = new Point(coordinates.getY().getLocation() + 1, maxLocation);
        coordinates.move(Direction.NORTH);
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveShouldIncreaseXWhenDirectionIsEast() {
        Point expected = new Point(coordinates.getX().getLocation() + 1, maxLocation);
        coordinates.move(Direction.EAST);
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveShouldDecreaseYWhenDirectionIsSouth() {
        Point expected = new Point(coordinates.getY().getLocation() - 1, maxLocation);
        coordinates.move(Direction.SOUTH);
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveShouldDecreaseXWhenDirectionIsWest() {
        Point expected = new Point(coordinates.getX().getLocation() - 1, maxLocation);
        coordinates.move(Direction.WEST);
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void toStringShouldReturnXAndY() {
        assertThat(coordinates.toString()).isEqualTo(x + " X " + y);
    }

}