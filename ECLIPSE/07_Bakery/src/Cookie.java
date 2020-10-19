
public class Cookie {
	
	//make instance variables
	private CookieType type;
	private double price;
	
	public Cookie(CookieType type, double price) {
		this.type = type;
		this.price = price;
	}
	public Cookie(CookieType type) {
		this(type, 2.25);
	}
	/**
	 * @return the type
	 */
	public CookieType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(CookieType type) {
		this.type = type;
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
	@Override
	public String toString() {
		return type + " Cookie, $" + price;
	}
	public Cookie(double price) {
		this.price = price;
	}
	
	
}
