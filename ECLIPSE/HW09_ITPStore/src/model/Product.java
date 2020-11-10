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
public abstract class Product implements Comparable<Product> {
	private String name;
	private double price;
	private double rating;
	
	
	public Product(String name, double price, double rating) {
		this.name = name;
		this.price = price;
		this.rating = rating;
		
	}
	public final int compareTo(Product p) {
		int num = (int) (price - p.price);
		if (num == 0) {
			//prices were close... see if they are the "Same"
			if(Math.abs(price - p.price) <= .001) { // same price
				num = name.compareTo(p.name);
				if(num == 0 ) { //name same
					num = (int)(rating- p.rating); // or look even closer at numbers
				}
			}
			else if (price < p.price){
				num = -1;
			}
			else {
				num = 1;
			}
		}
		return num;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(int rating) {
		// Ignore invalid ratings.
		if(rating > 0 && rating < 5)
			this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return this.name.equalsIgnoreCase(other.name)
				&& (Math.abs(this.price-other.price) < .0001)
				&& (Math.abs(this.rating-other.rating) < .0001);
	}
	
	

	@Override
	public String toString() {
		return  name + ", price= $" + String.format("%.2f", price) + ", rating=" + rating + "*";
	}

}
