package com.twu.refactoring;

public class Childrens extends Movie{

    public Childrens(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double determineAmounts(double thisAmount, Rental each) {
        thisAmount += 1.5;
        if (each.getDaysRented() > 3)
            thisAmount += (each.getDaysRented() - 3) * 1.5;
        return thisAmount;
    }
}
