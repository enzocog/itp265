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
public abstract class Product implements Comparable<Object> { 
	//init variables
	private String name;
	private double price;
	private double rating;
	

		
	
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
		return "Product [name=" + name + ", price=" + price + ", rating=" + rating + "]";
	}
	
	
	public int compareTo(Product x) {
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
	
	
	 public boolean equals(Object obj) 
	    { 
	          
	    // checking if both the object references are  
	    // referring to the same object. 
	    if(this == obj) 
	            return true; 
	          
	    
	        if(obj == null || obj.getClass()!= this.getClass()) 
	            return false; 
	          
	        // type casting of the argument.  
	        Product product = (Product) obj; 
	          
	        // comparing the state of argument with  
	        // the state of 'this' Object. 
	        return (product.name == this.name && product.price == this.price && product.rating == this.rating); 
	    } 
	
	
	
}
