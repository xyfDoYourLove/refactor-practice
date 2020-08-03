package com.twu.refactoring;

import java.util.HashMap;

public class Direction {
    private final char direction;

    public static HashMap<Character, Character> rightMap = new HashMap<>();
    public static HashMap<Character, Character> leftMap = new HashMap<>();

    static {
        rightMap.put('N', 'E');
        rightMap.put('S', 'W');
        rightMap.put('E', 'N');
        rightMap.put('W', 'S');
        leftMap.put('N', 'W');
        leftMap.put('S', 'E');
        leftMap.put('E', 'N');
        leftMap.put('W', 'S');
    }

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        if (rightMap.get(direction) != null) {
            return new Direction(rightMap.get(direction));
        }
        throw new IllegalArgumentException();
    }

    public Direction turnLeft() {
        if (leftMap.get(direction) != null) {
            return new Direction(leftMap.get(direction));
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Direction direction1 = (Direction) object;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
