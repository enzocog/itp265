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
		super();
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
		return "Vide o [genres=" + genres + ", getGenres()=" + getGenres() + ", getDuration()=" + getDuration()
				+ ", isIncludedWithPrime()=" + isIncludedWithPrime() + ", getReleaseYear()=" + getReleaseYear()
				+ ", toString()=" + super.toString() + ", getRating()=" + getRating() + ", getName()=" + getName()
				+ ", getPrice()=" + getPrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	public double getRentalPrice() {
		if (isIncludedWithPrime()) {
			return 0;
		}
		return getPrice() / 3;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
