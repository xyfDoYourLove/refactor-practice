package com.twu.refactoring;

public class NumberCruncher {

    public static final String EVEN = "EVEN";
    public static final String ODD = "ODD";
    public static final String POSITIVE = "POSITIVE";
    public static final String NEGATIVE = "NEGATIVE";

    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return countByOrder(EVEN);
    }

    public int countOdd() {
        return countByOrder(ODD);
    }

    public int countPositive() {
        return countByOrder(POSITIVE);
    }

    public int countNegative() {
        return countByOrder(NEGATIVE);
    }

    public int countByOrder(String order) {
        int count = 0;
        for (int number : numbers) {
            if (chooseOperation(order, number)) count++;
        }
        return count;
    }

    public Boolean chooseOperation(String order, int number) {
        switch (order) {
            case EVEN:
                return number % 2 == 0;
            case ODD:
                return number % 2 == 1;
            case POSITIVE:
                return number >= 0;
            case NEGATIVE:
                return number < 0;
            default:
                return false;
        }
    }
}
