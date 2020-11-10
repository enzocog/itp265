import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
* Brief Description of Code:
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
	public MapPractice() {
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
	
	public boolean emailCheck() {
		String key = sc.inputWord("What email would you like to see?");
		if (allPeople.containsKey(key)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean personCheck(Person x) {
		if (allPeople.containsValue(x)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void printSize() {
		System.out.println(allPeople.size());
		
	}
	
	public void printValues() {
		System.out.println(allPeople.values());
	}
	
	public void entrySet() {
		System.out.println(Arrays.asList(allPeople));
		
	}
	
	public void getPerson(String emailAddress) { //fix this
		if (allPeople.containsKey(emailAddress)) {
			String password = sc.inputLine("Input user password");
			if (allPeople.get(emailAddress).contains(password)) {
				System.out.println(allPeople.get(emailAddress));
			} 
			else {
				System.out.println("Sorry, that didn't meet our criteria!");
			}
		}
		else {
			System.out.print("fail");
		}
	}
	
	public boolean isEmpty() {
		return allPeople.isEmpty();
		
	}
	
	public void printKeys() {
		System.out.println(allPeople.keySet());
		
	}
	
	public void enterData() { //do this
		String classWord = sc.inputWord("What class would you like to create? (Person, Student, StudentTA, New Subclass, Faculty");
		
	}
	
	public static void main(String[] args) {
		MapPractice MapPractice = new MapPractice();
		MapPractice.printSize();
		System.out.println(MapPractice.emailCheck());
		MapPractice.getPerson("nguyenst@usc.edu");
		System.out.println(MapPractice.isEmpty());
		MapPractice.printKeys();
		MapPractice.printValues();
	}
	
	
}
