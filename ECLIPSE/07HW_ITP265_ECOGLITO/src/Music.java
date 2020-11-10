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
		super(name, price, rating, duration, isIncludedWithPrime, releaseYear);
		this.genres = genres;
	}


	

	/**
	 * @return the genres
	 */
	public MusicGenre getGenres() {
		return genres;
	}



	/**
	 * @param genres the genres to set
	 */
	public void setGenres(MusicGenre genres) {
		this.genres = genres;
	}



	@Override

	public String toString() {
		return "Music: Name:" + getName() + ", Genre:" + getGenres() + ", Duration: " + getDuration()
				+ ", Prime?: " + isIncludedWithPrime() + ", Release Year: " + getReleaseYear()
				+ ", Rating: " + getRating() + 
				 ", Price: " + getPrice();
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Music))
			return false;
		Music other = (Music) obj;
		if (genres != other.genres)
			return false;
		return true;
	}

	



	
}
