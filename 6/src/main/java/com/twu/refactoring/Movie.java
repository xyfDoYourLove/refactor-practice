package com.twu.refactoring;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public static Movie getMovieByPriceCode(Rental each) {
		switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				return new Regular(each.getMovie().getTitle(), each.getMovie().getPriceCode());
			case Movie.NEW_RELEASE:
				return new NewRelease(each.getMovie().getTitle(), each.getMovie().getPriceCode());
			case Movie.CHILDRENS:
				return new Childrens(each.getMovie().getTitle(), each.getMovie().getPriceCode());
			default:
				return new Movie(each.getMovie().getTitle(), each.getMovie().getPriceCode());
		}
	}

	public double determineAmounts(double thisAmount, Rental each) {
		return 0;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
    	priceCode = arg;
	}

	public String getTitle () {
		return title;
	}
}

