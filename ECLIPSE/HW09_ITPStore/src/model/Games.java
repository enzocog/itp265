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
public class Games extends Item {
	private String description;
	
	public Games(String name, double price, double rating, int quantity, String description) {
		super(name, price,  rating, quantity);
		this.description = description;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString() {
		return "Game: " + super.toString() + ", " + description;
	}
}
