import java.util.*;
import java.time.LocalDate;
/**
* Brief Description of Code: Helps us make a list of type person
*
* @author Michael Shahidi, Enzo Coglitore
* ITP 265, FALL 2020, Coffee Section
* Assignment 08, Week 10
* Email: mkshahid@usc.edu, ecoglito@usc.edu
*/
public class Factory {

	public static List<Person> makePeople(){
		List<Person> p = new ArrayList<Person>();
		p.add(new Person("Michael Shahidi", LocalDate.of(2001, 03, 03), "mkshahid@usc.edu", "BigFootballGuy"));
		p.add(new Person("Enzo Coglitore", LocalDate.of(2001, 02, 02), "ecoglito@usc.edu", "MrFiveFeet"));
		p.add(new Person("Steve Nguyen", LocalDate.of(2001, 01, 01), "nguyenst@usc.edu", "MrFiveFeetPt2"));
		return p;
	}
	
	public static void print(List<Person> people) {
		for (Person p: people)
			System.out.println(p);
	}
	
	public static void main(String[] args) {
		List<Person> people = makePeople();
		print(people);
	}
}
