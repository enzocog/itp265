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
public class Music extends StreamableProduct {
	
	private MusicGenre genre;
	

	/**
	 * @param name
	 * @param price
	 * @param rating
	 * @param duration
	 * @param isIncludedWithPrime
	 * @param releaseYear
	 */
	public Music(String name, double price, double rating, double duration,
				boolean isIncludedWithPrime, String releaseYear, MusicGenre genre) {
		super(name, price, rating, duration, isIncludedWithPrime, releaseYear);
		this.genre = genre;
	}
	
	

	public String toString() {
		return super.toString() + ", Genre: " + genre;
	}
}
