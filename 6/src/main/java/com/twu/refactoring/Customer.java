package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		StringBuffer result = addHeader();

		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();

			// determine amounts for each line
			Movie movie = Movie.getMovieByPriceCode(each);
			thisAmount = movie.determineAmounts(thisAmount, each);

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if (each.isTwoDayNewReleaseRental())
				frequentRenterPoints++;

			result = each.showFigures(result, thisAmount);
			totalAmount += thisAmount;

		}
		// add footer lines
		result = addFooter(result, totalAmount, frequentRenterPoints);
		return result.toString();
	}

	public StringBuffer addHeader() {
		StringBuffer result = new StringBuffer();
		result.append("Rental Record for " + getName() + "\n");
		return result;
	}

	public StringBuffer addFooter(StringBuffer result, double totalAmount, int frequentRenterPoints) {
		result.append("Amount owed is " + totalAmount + "\n");
		result.append("You earned " + frequentRenterPoints + " frequent renter points");
		return result;
	}

}
