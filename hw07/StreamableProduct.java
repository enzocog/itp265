/**
 * 
 * 
 * @author This is a base streamable product class
 * Enzo Coglitore
 * ITP 265, Coffee
 * HW 07
 * Ecoglito@usc.edu
 */ 
public abstract class StreamableProduct extends Product {
	
	//init variables
	private double duration;
	private boolean isIncludedWithPrime;
	private int releaseYear;

	
	//getters and setters
	
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

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		return "StreamableProduct [duration=" + duration + ", isIncludedWithPrime=" + isIncludedWithPrime
				+ ", releaseYear=" + releaseYear + "]";
	}
	
	
	
	
	

}
