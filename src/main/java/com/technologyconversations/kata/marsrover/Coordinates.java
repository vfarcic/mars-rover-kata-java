package com.technologyconversations.kata.marsrover;

public class Coordinates {

    private Point x;
    public void setX(Point value) { x = value; }
    public Point getX() { return x; }

    private Point y;
    public void setY(Point value) { y = value; }
    public Point getY() { return y; }

    public Coordinates(int xValue, int yValue, int maxXValue, int maxYValue) {
        setX(new Point(xValue, maxXValue));
        setY(new Point(yValue, maxYValue));
    }

    public void move(final Direction direction) {
        switch (direction) {
            case NORTH:
                y.forward();
                break;
            case EAST:
                x.forward();
                break;
            case SOUTH:
                y.backward();
                break;
            case WEST:
                x.backward();
                break;
        }
    }

    @Override
    public String toString() {
        return getX().getLocation() + " X " + getY().getLocation();
    }

}
