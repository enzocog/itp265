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
public class Electronics extends Item{
	private String size;
	private String weight;
	
	public Electronics(String name, double price,  double rating, int quantity, String size,
			String weight) {
		super(name, price, rating, quantity);
		this.size = size;
		this.weight = weight;
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return super.toString() + ", size = " + size + ", weight = " + weight;
	}

}
