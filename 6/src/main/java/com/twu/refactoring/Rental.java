package com.twu.refactoring;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Boolean isTwoDayNewReleaseRental() {
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > 1) {
            return true;
        }
        return false;
    }

    public StringBuffer showFigures(StringBuffer result, double thisAmount) {
        result.append("\t" + this.getMovie().getTitle() + "\t" + thisAmount + "\n");
        return result;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}