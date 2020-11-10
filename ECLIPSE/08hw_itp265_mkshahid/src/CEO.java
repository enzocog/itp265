import java.time.LocalDate;
/**
* Brief Description of Code:
*
* @author Michael Shahidi, Enzo Coglitore
* ITP 265, FALL 2020, Coffee Section
* Assignment 08, Week 10
* Email: mkshahid@usc.edu, ecoglito@usc.edu
*/
public class CEO extends Person {

	private double netWorth;
	
	/**
	 * @param name
	 * @param bday
	 */
	public CEO(String name, LocalDate bday, String email, String password, double netWorth) {
		super(name, bday, email, password);
		this.netWorth = netWorth;
	}
		
	/**
	 * @param name
	 * @param year
	 * @param month
	 * @param day
	 */
	public CEO(String name, int year, int month, int day) {
		super(name, year, month, day);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Increases sleepiness by 3 rather than 1
	 */
	@Override
	public void increaseSleepiness() {
		super.increaseSleepiness();
		super.increaseSleepiness();
		super.increaseSleepiness();
	}

	@Override
	public String toString() {
		return super.toString() + ", Net Worth= " + netWorth;
	}

	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		return super.equals(other);
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return super.compareTo(o);
	}
	
	

}
