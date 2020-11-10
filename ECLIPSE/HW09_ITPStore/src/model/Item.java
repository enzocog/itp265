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
public abstract class Item extends Product{
	private int quantity;
	
	public Item(String name, double price, double rating, int quantity ) {
		super(name, price, rating);
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void removeInventory(int numProducts) {
		int value = this.quantity - numProducts;
		if(value >= 0 ) {
			this.quantity = value;
		}
		
	}

	
}
