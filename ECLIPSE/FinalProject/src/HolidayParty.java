/**
	ITP 265 COFFEE FINAL PROJECT
	ECOGLITO@USC.EDU
	Enzo Coglitore, Coffee
	This Class Does: Makes the HolidayParty Classes
 * 
 */


public class HolidayParty extends Party implements BringFood {

	private String holiday;
	private boolean food;
	
	
	public HolidayParty(String name, String location, String time, int people, String holiday, boolean food) {
		super(name, location, time, people);
		this.holiday = holiday;
		this.food = true;
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the holiday
	 */
	public String getHoliday() {
		return holiday;
	}
	
	public boolean bringFood() {
		if (holiday.equalsIgnoreCase("Christmas") || holiday.equalsIgnoreCase("Thanksgiving") || holiday.equalsIgnoreCase("Easter")) {
			return food = true;
		}
		else {
			return food = false;
		}
		
	}
	
	public String toString() {
		return "Holiday Party: Name: " + getName() + " Location: " + getLocation() + " Time: " + getTime() + " People: " + getPeople() + " Holiday: " + holiday + "BringFood: " + food;
	}
	
	
	

}
