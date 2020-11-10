import java.lang.Comparable;
/**
 * 
 * 
 * @author This is a base product class
 * Enzo Coglitore
 * ITP 265, Coffee
 * HW 07
 * Ecoglito@usc.edu
 *
 */
public abstract class Product implements Comparable<Product> { 
	//init variables
	private String name;
	private double price;
	private double rating;
	
	public Product(String name, double price, double rating) {
		this.name = name;
		this.price = price;
		this.rating = rating;
	}
		
	
	//getter and setters
	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}


	@Override
	public String toString() {
		return "Name: " + name + ", price: " + String.format("%.2f", price) + ", rating " + rating;
	}
	
	 
	public int compareTo(Product x) { //compare by price
		double diff = this.getPrice() - x.getPrice();
		if (Math.abs(diff) <= .0001) {
			return 0;
		}
		else if (diff > 1) {
			return 1;
		}
		else {
			return -1;
		}
	
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
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		return true;
	}
	

	
	
	 


}
