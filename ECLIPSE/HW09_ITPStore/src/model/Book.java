package model;
/**
 * Write description of class here
 *
 * @author Kendra Walther
 * ITP 265
 * STORE HOMEWORK, Starter code
 * Email: kwalther@usc.edu
 *
 */

public class Book extends Item implements Rentable{
	private String genre;
	private int numberOfPages;
	private final double RENTAL_PRICE = .99;
	
	public Book(String name, double price, double rating, int quantity, String genre, int numberOfPages) {
		super(name, price,  rating, quantity);
		this.genre = genre;
		this.numberOfPages = numberOfPages;
	}
	public String getGenre() {
		return genre;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public String toString() {
		return super.toString() + " genre = " + genre + " and numPages = " + numberOfPages;
	}
	@Override
	public double getRentalPrice() {
	
		return RENTAL_PRICE;
	}
	
}
