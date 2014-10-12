package com.technologyconversations.kata.marsrover;

/*
Method receiveCommands should be used to transmit commands to the rover.
 */
public class Rover {

    private Coordinates coordinates;
    public void setCoordinates(Coordinates value) {
        coordinates = value;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }

    private Direction direction;
    public void setDirection(Direction value) {
        direction = value;
    }
    public Direction getDirection() {
        return direction;
    }

    public Rover(Coordinates coordinatesValue, Direction directionValue) {
        setCoordinates(coordinatesValue);
        setDirection(directionValue);
    }

    public void receiveCommands(String commands) throws Exception {
        for (char command : commands.toCharArray()) {
            receiveSingleCommand(command);
        }
    }

    public void receiveSingleCommand(char command) throws Exception {
        if (command == 'M') {
            getCoordinates().move(getDirection());
        } else if (command == 'L') {
            changeDirection(-1);
        } else if (command == 'R') {
            changeDirection(1);
        } else {
            throw new Exception("Command " + command + " is unknown.");
        }
    }

    public String getPosition() {
        return getCoordinates().toString() + " " + getDirection().getShortName();
    }

    private void changeDirection(int directionStep) {
        int directions = Direction.values().length;
        int index = (directions + getDirection().getValue() + directionStep) % directions;
        setDirection(Direction.values()[index]);
    }

}