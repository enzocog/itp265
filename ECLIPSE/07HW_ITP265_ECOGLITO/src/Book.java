/**
 * 
 * 
 * @author This is an Books class
 * Enzo Coglitore
 * ITP 265, Coffee
 * HW 07
 * Ecoglito@usc.edu
 *
 */
public class Book extends Item implements Rentable {
	// init variables
	private String genre;
	private int numberOfPages;
	private final static double RENTAL_PRICE = .99;

	
	public Book(String name, double price, double rating, int quantity, String genre, int numberOfPages) { //constructor
		super();
		this.genre = genre;
		this.numberOfPages = numberOfPages;
	}
	
	//getter and setters
	

	public String getGenre() {
		return genre;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public double getRENTAL_PRICE() {
		return RENTAL_PRICE;
	}

	
	
	
	@Override
	public String toString() {
		return "Book [genre=" + genre + ", numberOfPages=" + numberOfPages + ", getGenre()=" + getGenre()
				+ ", getNumberOfPages()=" + getNumberOfPages() + ", getRENTAL_PRICE()=" + getRENTAL_PRICE()
				+ ", getQuantity()=" + getQuantity() + ", getRating()=" + getRating() + ", getName()=" + getName()
				+ ", getPrice()=" + getPrice() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	public static double getRentalPrice() {
		return RENTAL_PRICE;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

