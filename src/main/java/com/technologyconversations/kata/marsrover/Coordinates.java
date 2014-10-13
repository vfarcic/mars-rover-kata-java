package com.technologyconversations.kata.marsrover;

public class Coordinates {

    private Point x;
    public void setX(Point value) { x = value; }
    public Point getX() { return x; }

    private Point y;
    public void setY(Point value) { y = value; }
    public Point getY() { return y; }

    private Direction direction;
    public void setDirection(Direction value) {
        direction = value;
    }
    public Direction getDirection() {
        return direction;
    }

    public Coordinates(Point xValue, Point yValue, Direction directionValue) {
        setX(xValue);
        setY(yValue);
        setDirection(directionValue);
    }

    public void move(Direction directionValue) {
        switch (directionValue) {
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

    public void moveForward() {
        move(direction);
    }

    public void moveBackward() {
        move(direction.getBackwardDirection());
    }

    private void changeDirection(Direction directionValue, int directionStep) {
        int directions = Direction.values().length;
        int index = (directions + directionValue.getValue() + directionStep) % directions;
        direction = Direction.values()[index];
    }

    public void changeDirectionLeft() {
        changeDirection(direction, -1);
    }

    public void changeDirectionRight() {
        changeDirection(direction, 1);
    }

    @Override
    public String toString() {
        return getX().getLocation() + " X " + getY().getLocation() + " " + getDirection().getShortName();
    }

}
