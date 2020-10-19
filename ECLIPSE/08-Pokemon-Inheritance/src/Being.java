
/**
 * Brief Description Of Code: BASE CLASS FOR ALL THINGS IN POKEMON UNIVERSE 
 * @author Enzo Coglitore
 * ITP 265, FALL 2020, Coffee Section
 * Assignment XX, Week ##
 * Email: ecoglito@usc.edu
 */
public class Being {
	private String name;
	private int healthPoints;
	private Region region;
	/**
	 * @param name
	 * @param healthPoints
	 * @param region
	 */
	public Being(String name, int healthPoints, Region region) {
		super();
		this.name = name;
		this.healthPoints = healthPoints;
		this.region = region;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the healthPoints
	 */
	public int getHealthPoints() {
		return healthPoints;
	}
	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}
	
	public boolean addHealth(int amount) {
		healthPoints += amount;
		return true;
		
		
	}
	
	public boolean subtractHealth(int amount) {
		healthPoints -= amount;
		return true;
		
		
	}
	@Override
	public String toString() {
		return "Being [name=" + name + ", healthPoints=" + healthPoints + ", region=" + region + "]";
	}
	
	
	
	
	
	
}
