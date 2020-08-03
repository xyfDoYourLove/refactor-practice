package com.twu.refactoring;

public class Regular extends Movie{

    public Regular(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double determineAmounts(double thisAmount, Rental each) {
        thisAmount += 2;
        if (each.getDaysRented() > 2)
            thisAmount += (each.getDaysRented() - 2) * 1.5;
        return thisAmount;
    }
}
