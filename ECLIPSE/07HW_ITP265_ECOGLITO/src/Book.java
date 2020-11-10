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
public class Book extends Item implements Rentable{
	// init variables
	private String genre;
	private int numberOfPages;
	private final static double RENTAL_PRICE = .99;

	
	public Book(String name, double price, double rating, int quantity, String genre, int numberOfPages) { //constructor
		super(name, price, rating, quantity);
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

	
	
	@Override
	public String toString() {
		return "Book: " + super.toString() + ", Genre: " + genre + ", number of pages: " + numberOfPages + ", Rental Price: " + getRentalPrice();
	}

	public double getRentalPrice() {
		return RENTAL_PRICE;
	}


}

