/**
	ITP 265 COFFEE FINAL PROJECT
	ECOGLITO@USC.EDU
	Enzo Coglitore, Coffee
	This Class Does: Implements the PotLuck Party Class
 * 
 */

public class PotLuck extends Party implements BringFood {
    //init variables
	private String foodTheme;
	private boolean food;
	public PotLuck(String name, String location, String time, int people, String foodTheme, boolean food) {
		super(name, location, time, people);
		this.foodTheme = foodTheme;
		this.food = food;
	}
	/**
	 * @return the foodTheme
	 */
	public String getFoodTheme() {
		return foodTheme;
	}
	
	
	public boolean bringFood() {
		return true;
	}
	
	public String toString() {
		return "PotLuck: Name: " + getName() + " Location: " + getLocation() + " Time: " + getTime() + " People: " + getPeople() + " Theme: " + foodTheme + " BringFood: " + food;
	}


}
