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
public abstract class StreamableProduct extends Product {
	private double duration;
	private boolean isIncludedWithPrime;
	private String releaseYear;
	

	public StreamableProduct(String name, double price, double rating, double duration, boolean isIncludedWithPrime, String releaseYear) {
		super(name, price, rating);
		this.duration = duration;
		this.isIncludedWithPrime = isIncludedWithPrime;
		this.releaseYear = releaseYear;
		
	}
	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public boolean isIncludedWithPrime() {
		return isIncludedWithPrime;
	}

	public void setIncludedWithPrime(boolean isIncludedWithPrime) {
		this.isIncludedWithPrime = isIncludedWithPrime;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public String toString() {
		String s = "Streamable " + this.getClass().getSimpleName() ; // get concrete class simple name
		if(isIncludedWithPrime) {
			s += " (free with prime)";
		}
		s += " ";
		return s + super.toString();
	}

}
