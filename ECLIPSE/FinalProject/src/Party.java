import java.util.*;
/**
	ITP 265 COFFEE FINAL PROJECT
	ECOGLITO@USC.EDU
	Enzo Coglitore, Coffee
	This Class Does: Sets up the Abstract Class for Party
 * 
 */

public abstract class Party {
	//init variables
	private String name;
	private String location;
	private String time;
	private int people;
	
	public Party(String name, String location, String time, int people) {
		this.name = name;
		this.location = location;
		this.time = time;
		this.people = people;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the people
	 */
	public int getPeople() {
		return people;
	}

	/**
	 * @param people the people to set
	 */
	public void setPeople(int people) {
		this.people = people;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	
	//tostring method
	
	public String toString() {
		return "Party: Name: " + name + " Location: " + location + " Time: " + time + " People: " + people;
	}
	
	
	
	
	
}
