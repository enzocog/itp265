import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xerces.internal.impl.xs.traversers.XSAttributeChecker;
/**
* Brief Description of Code: MapPractice w/ hashmaps
*
* @author Michael Shahidi, Enzo Coglitore
* ITP 265, FALL 2020, Coffee Section
* Assignment 08, Week 10
* Email: mkshahid@usc.edu, ecoglito@usc.edu
*/
public class MapPractice {
	
	private UI sc;
	private Map<String, List<Person>> allPeople; //declaring a map
	
	/**
	 * 
	 */
	public MapPractice() { //constructor
		sc = new UI();
		List<Person> people =  Factory.makePeople();
		allPeople = new HashMap<>(people.size() + 10);
		Person p = new Person("Kendra Walther", LocalDate.of(1985, 01, 01), "kwalther@usc.edu", "ILoveITP");
		people.add(p);
		for (Person person: people) {
			List<Person> p1 = new ArrayList<Person>();
			p1.add(person);
			allPeople.put(person.getEmail(), p1);
		}
	
		}
	
	public boolean emailCheck() { //check if email is in
		String key = sc.inputWord("What email would you like to see?");
		if (allPeople.containsKey(key)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean personCheck(Person x) { //checks if person in
		if (allPeople.containsValue(x)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void printSize() { //prints size
		System.out.println(allPeople.size());
		
	}
	
	public void printValues() { //prints values
		System.out.println(allPeople.values());
	}
	
	public void entrySet() { //prints out key + value
		System.out.println(Arrays.asList(allPeople));
		
	}
	
	public void getPerson(String emailAddress) { //checks for user with email
		if (allPeople.containsKey(emailAddress)) {
			Person p = allPeople.get(emailAddress).get(0);
			String password = sc.inputLine("Input user password:");
			if (p.checkPassword(password) == true) {
				System.out.println("Welcome " + p.getName() + "!");
			}
			else {
				System.out.println("Sorry, your password isn't correct.");
			}
		}
		else {
			System.out.print("Sorry, no matching email address found.");
		}
	}
	
	public boolean isEmpty() { //checks if empty
		return allPeople.isEmpty();
		
	}
	
	public void printKeys() { //prints out the keys
		System.out.println(allPeople.keySet());
		
	}
	
	Map<String, String> mapName = new HashMap<String, String>();
	public void enterData() { //lets user input data
		boolean repeat = true;
		while (repeat) {
			String classWord = sc.inputWord("What class would you like to create? (Person, Student, StudentTA, CEO, Faculty): ");
				String name = sc.inputLine("Please enter the person's name");
				int birthYear = sc.inputInt("Please enter " + name + "'s birth year", 0, 2020);
				int birthMonth = sc.inputInt("Please enter " + name + "'s birth month", 1, 12);
				int birthDay = sc.inputInt("Please enter " + name + "'s birth day", 1, 31);
				LocalDate bday = LocalDate.of(birthYear, birthMonth, birthDay);
				String email = sc.inputWord("Please enter " + name + "'s email address");
				String password = sc.inputWord("Please enter " + name + "'s password");
				if (classWord.equalsIgnoreCase("Person")) {
					Person p = new Person(name, bday, email, password);
					List<Person> people = new ArrayList<Person>();
					people.add(p);
					allPeople.put(email, people);
					entrySet();
				} 
				if (classWord.equalsIgnoreCase("Student")) {
					double gpa = sc.inputDouble("Please enter GPA: ");
					String major = sc.inputLine("Please enter major: ");
					Student p = new Student(name, bday, gpa, major);
					List<Person> people = new ArrayList<Person>();
					people.add(p);
					allPeople.put(email, people);
					entrySet();
				}
				else if (classWord.equalsIgnoreCase("StudentTA")){
					double gpa = sc.inputDouble("Please enter GPA: ");
					String major = sc.inputLine("Please enter major: ");
					String course = sc.inputLine("Course");
					StudentTA p = new StudentTA(name, bday, gpa, major, course);
					List<Person> people = new ArrayList<Person>();
					people.add(p);
					allPeople.put(email, people);
					entrySet();
				}
				else if (classWord.equalsIgnoreCase("CEO")){
					double netWorth = sc.inputDouble("Please enter netWorth: ");
					CEO p = new CEO(name, bday, email, password, netWorth);
					List<Person> people = new ArrayList<Person>();
					people.add(p);
					allPeople.put(email, people);
					entrySet();
				}
				else if (classWord.equalsIgnoreCase("Faculty")){
					String officeLocation = sc.inputLine("Enter office location: ");
					Faculty p = new Faculty(name, bday, officeLocation);
					List<Person> people = new ArrayList<Person>();
					people.add(p);
					allPeople.put(email, people);
					entrySet();
				}
				
				
			String xCheck = sc.inputLine("Would you like to continue (y/n)");
			if (xCheck.equalsIgnoreCase("n")) {
				repeat = false;
			}
		
		}
	}
	
	public static void main(String[] args) {
		
		MapPractice MapPractice = new MapPractice();
		MapPractice.enterData();
		MapPractice.printSize();
		System.out.println(MapPractice.emailCheck());
		MapPractice.getPerson("nguyenst@usc.edu");
		System.out.println(MapPractice.isEmpty());
		MapPractice.printKeys();
		MapPractice.printValues();
		MapPractice.enterData();
		MapPractice.getPerson("ecoglito@usc.edu");
	}
	
	
}
