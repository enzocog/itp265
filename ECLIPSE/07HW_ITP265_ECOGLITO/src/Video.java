/**
 * 
 * 
 * @author This is the base video class
 * Enzo Coglitore
 * ITP 265, Coffee
 * HW 07
 * Ecoglito@usc.edu
 *
 */
public class Video extends StreamableProduct implements Rentable {
	private Genre genres;
	public Video(String name, double price, double rating, double duration, boolean isIncludedWithPrime, int releaseYear, Genre genres) { //constructor
		super(name, price, rating, duration, isIncludedWithPrime, releaseYear);
		this.genres = genres;
	}
	public Genre getGenres() {
		return genres;
	}
	public void setGenres(Genre genres) {
		this.genres = genres;
	}
	
	@Override
	public String toString() {
		return "Video: " + super.toString() + " Genre: " + genres +", Rental Price: " + getRentalPrice();
	}
	
	public double getRentalPrice() {
		if (isIncludedWithPrime()) {
			return 0;
		}
		return this.getPrice() / 3;
	}

	
	
	
}
