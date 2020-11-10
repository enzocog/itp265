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

public class StudentTA extends Student {
	
	private String course; // the course for which the Student is a TA

	public StudentTA(String name, LocalDate birthday, double gpa, String major, String course) {
		super(name, birthday, gpa, major);
		this.course = course;
	}

	public StudentTA(String name, int year, Month month, int day, double gpa, String major, String course) {
		this(name, LocalDate.of(year, month, day), gpa, major, course);
	}

	public StudentTA(String name, int year, int month, int day, double gpa, String major, String course) {
		this(name, LocalDate.of(year, month, day), gpa, major, course);
	}
	
	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		//super jumps up ONE level
		return super.toString() + " and TA for: " + course;
	}
}