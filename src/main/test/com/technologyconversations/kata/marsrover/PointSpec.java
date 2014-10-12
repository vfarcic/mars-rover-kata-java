package com.technologyconversations.kata.marsrover;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/*
Point is a two-dimensional point on the grid.
New instance is created with initial location and maximum location that can be reached on that axis.
Methods forward/backward increase/decrease location.
If maximum location is reached, forward/backward methods wrap location.
*/
public class PointSpec {

    Point point;
    private final int location = 5;
    private final int maxLocation = 9;

    @Before
    public void beforePointTest() {
        point = new Point(location, maxLocation);
    }

    @Test
    public void newInstanceShouldSetLocationAndMaxLocationParams() {
        assertThat(point.getLocation()).isEqualTo(location);
        assertThat(point.getMaxLocation()).isEqualTo(maxLocation);
    }

    @Test
    public void forwardShouldIncreasePointValueByOne() {
        int expected = point.getLocation() + 1;
        point.forward();
        assertThat(point.getLocation()).isEqualTo(expected);
    }

    @Test
    public void backwardShouldDecreasePointValueByOne() {
        int expected = point.getLocation() - 1;
        point.backward();
        assertThat(point.getLocation()).isEqualTo(expected);
    }

    @Test
    public void forwardShouldSetValueToZeroIfMaxLocationIsPassed() {
        point.setLocation(point.getMaxLocation());
        point.forward();
        assertThat(point.getLocation()).isZero();
    }

    @Test
    public void backwardShouldSetValueToMaxLocationIfZeroLocationIsPassed() {
        point.setLocation(0);
        point.backward();
        assertThat(point.getLocation()).isEqualTo(point.getMaxLocation());
    }

}