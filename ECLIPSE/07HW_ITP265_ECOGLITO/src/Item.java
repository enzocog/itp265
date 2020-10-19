/**
 * 
 * 
 * @author This is an item class
 * Enzo Coglitore
 * ITP 265, Coffee
 * HW 07
 * Ecoglito@usc.edu
 *
 */


public abstract class Item extends Product {
	//init variables
	private int quantity;
	
	//getter and setters
	

	public Item(String name, double price, double rating, int quantity) {
		super(name, price, rating);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return super.toString() + ", quantity " + quantity;
	}
	
	
	
	

}
