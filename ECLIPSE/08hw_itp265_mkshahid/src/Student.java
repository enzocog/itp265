import java.time.LocalDate;
import java.time.Month;
/**
* Brief Description of Code:
*
* @author Michael Shahidi, Enzo Coglitore
* ITP 265, FALL 2020, Coffee Section
* Assignment 08, Week 10
* Email: mkshahid@usc.edu, ecoglito@usc.edu
*/

public class Student extends Person{
	private double gpa;
	private String major;
	private final int ID_NUM;
	
	private static int counter = 100; // STATIC means one copy exists in memory
	// CLASS level variable, part of our template, "factory"
	// objects themselves don't "have" this data (Not an instance variable)
	// one memory location contains this data that all Students have access to
	// Bulletin Board in Student that all students could see...
	
	
	
	public Student(String name, LocalDate birthday, double gpa, String major) {
		super(name, birthday);
		this.gpa = gpa;
		this.major = major;
		ID_NUM = counter;
		Student.counter++; //change the shared piece of memory
	
	}
	public Student(String name, int year, Month month, int day, double gpa, String major) {
		this(name, LocalDate.of(year, month, day), gpa, major);
	
	}
	public Student(String name, int year, int month, int day, double gpa, String major) {
		this(name, LocalDate.of(year, month, day), gpa, major);
		
	}
	public Student(String name, int year, int month, int day, String major) {
		this(name, LocalDate.of(year, month, day), 4.0, major);
		
	}
	@Override
	public void drawInAscii() {
		
		System.out.print("b"); 
		super.drawInAscii();
	}
	@Override
	public void increaseSleepiness() {
		sleepiness+=10;
	}
	@Override
	public void eatFood() {
		super.eatFood();
		System.out.println("(Even better if that pizza is free)");
	}

	@Override
	public String toString() {
		return "Student " + super.toString() + ", major=" + major + ", ID_NUM=" + ID_NUM;
	}
	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}
	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * @return the iD_NUM
	 */
	public int getID_NUM() {
		return ID_NUM;
	}
	
	public static void main(String[] args) {
		Student x = new Student("Sarah", 1999, Month.NOVEMBER, 1, 4.0, "applied math");
		System.out.println(x);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_NUM;
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		return result;
	}	
}