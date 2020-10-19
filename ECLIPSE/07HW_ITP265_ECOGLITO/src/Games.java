/**
 * 
 * 
 * @author This is an Games class
 * Enzo Coglitore
 * ITP 265, Coffee
 * HW 07
 * Ecoglito@usc.edu
 *
 */
public class Games extends Item {
	//init variables
	private String description;
	

	public Games(String name, double price, double rating, int quantity, String description) { //constructor
		super(name, price, rating, quantity);
		this.description = description;
		// TODO Auto-generated constructor stub
	}
	
	//getter and setters

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Games: Name: " + getName() + ", Price: " + getPrice() + ", Rating: " + getRating() + ", Quantity: " + getQuantity() + ", Description: " + getDescription();	
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	
	
}
