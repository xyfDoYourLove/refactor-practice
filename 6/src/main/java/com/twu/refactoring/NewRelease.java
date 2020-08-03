package com.twu.refactoring;

public class NewRelease extends Movie{

    public NewRelease(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double determineAmounts(double thisAmount, Rental each) {
        thisAmount += each.getDaysRented() * 3;
        return thisAmount;
    }
}
