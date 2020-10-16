/**
 * 
 * 
 * @author This is an Electronics class
 * Enzo Coglitore
 * ITP 265, Coffee
 * HW 07
 * Ecoglito@usc.edu
 *
 */
public class Electronics extends Item {
	//init variables
	private String size;
	private String weight;

	public Electronics(String name, double price, double rating, int quantity, String size, String weight) { //constructor
		super();
		this.size = size;
		this.weight = weight;
		// TODO Auto-generated constructor stub
	}
	//getter and setters
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

	@Override
	public String toString() {
		return "Electronics [size=" + size + ", weight=" + weight + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	

}
