
/**
 * Write description of class here
 *
 * @author Kendra Walther
 * ITP 265, Fall 2019
 * Week 01
 * Email: kwalther@usc.edu
 *
 */
public class Book implements Comparable<Book>{
	private String title;
	private String author;
	private int numPages;
	private double price;
	/**
	 * @param title
	 * @param author
	 * @param numSold
	 */
	public Book(String title, String author, int numSold) {
		this.title = title;
		this.author = author;
		this.numPages = numSold;
		price = 9.99;
	}
	
	
	
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}




	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}




	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumPages() {
		return numPages;
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", numPages=" + numPages + "]";
	}




	@Override
	public int compareTo(Book o) {
		
	//	System.err.println("In compareTo, Looking at: " + this.title 
	//			+ " AND comparing to " + o.title);
		
		// int tells us >, < , = (pos, neg, 0 number)
		// numpages, price, title, author: Order we want
		int diff =this.numPages - o.numPages; 

		if(diff == 0) {
			// equal for now (same num sold), look at more characteriscs
			double num = this.price - o.price;
			if(Math.abs(num) < .001) { //esentially 0
				//look at more characteristics
				diff = this.title.compareTo(o.title);
				if(diff == 0) {
					diff = this.author.compareTo(o.author);
				}
			}
			else if (num <0) {
				diff = -1; // any negative number
			}
			else { // > 0
				diff = 1; // any positive number
			}
		}
	
		return diff;
	}
	
}
