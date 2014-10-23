package com.technologyconversations.kata.marsrover;

public enum Direction {

    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private char shortName;

    private Direction(char shortNameValue) {
        shortName = shortNameValue;
    }

    public char getShortName() { return shortName; }

}
