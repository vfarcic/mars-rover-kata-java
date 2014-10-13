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

    public Rover(Coordinates coordinatesValue) {
        setCoordinates(coordinatesValue);
    }

    public void receiveCommands(String commands) throws Exception {
        for (char command : commands.toCharArray()) {
            receiveSingleCommand(command);
        }
    }

    public void receiveSingleCommand(char command) throws Exception {
        switch(Character.toUpperCase(command)) {
            case 'F':
                getCoordinates().moveForward();
                break;
            case 'B':
                getCoordinates().moveBackward();
                break;
            case 'L':
                getCoordinates().changeDirectionLeft();
                break;
            case 'R':
                getCoordinates().changeDirectionRight();
                break;
            default:
                throw new Exception("Command " + command + " is unknown.");
        }
    }

    public String getPosition() {
        return getCoordinates().toString();
    }

}