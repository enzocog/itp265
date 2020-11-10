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

public class Video extends StreamableProduct implements Rentable{
	
	private Genre genre;

	public Video(String name, double price, double rating, double duration, boolean isIncludedWithPrime, String releaseYear, Genre genre) {
		super(name, price, rating, duration, isIncludedWithPrime, releaseYear);
		
		this.genre = genre;
	}


	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String toString() {
		return super.toString() + ", Genre = " + genre;
	}


	@Override
	public double getRentalPrice() {
		if (super.isIncludedWithPrime()) {
			return 0.0;
		}
		else
			return super.getPrice() / 3.0;
	}
}
