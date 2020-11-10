/**
	ITP 265 COFFEE FINAL PROJECT
	ECOGLITO@USC.EDU
	Enzo Coglitore, Coffee
	This Class Does: Makes the Birthday Class
 * 
 */

/**
 * @author enzoc
 *
 */
public class Birthday extends Party {
	private String birthdayPerson;
	/**
	 * @param name
	 * @param location
	 * @param time
	 * @param people
	 */
	public Birthday(String name, String location, String time, int people, String birthdayPerson) {
		super(name, location, time, people);
		this.birthdayPerson = birthdayPerson;
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the birthdayPerson
	 */
	public String getBirthdayPerson() {
		return birthdayPerson;
	}
	
	public String toString() {
		return "Birthday Party: Name: " + getName() + " Location: " + getLocation() + " Time: " + getTime() + " People: " + getPeople() + " BirthdayPerson: " + birthdayPerson;
	}

}