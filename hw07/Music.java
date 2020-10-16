/* 
 * 
 * @author This is an music class
 * Enzo Coglitore
 * ITP 265, Coffee
 * HW 07
 * Ecoglito@usc.edu
 *
 */


public class Music extends StreamableProduct {
	//init var
	private MusicGenre genres;
	
	
	public Music(String name, double price, double rating, double duration, boolean isIncludedWithPrime, int releaseYear, MusicGenre genres) { //constructor
		super();
		this.genres = genres;
	}


	@Override
	public String toString() {
		return "Music [genres=" + genres + ", getDuration()=" + getDuration() + ", isIncludedWithPrime()="
				+ isIncludedWithPrime() + ", getReleaseYear()=" + getReleaseYear() + ", toString()=" + super.toString()
				+ ", getRating()=" + getRating() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
