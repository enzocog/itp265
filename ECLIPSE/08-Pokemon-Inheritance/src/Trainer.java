import java.util.ArrayList;

/**
 * Brief Description Of Code: Being in our pokemon game
 * @author Enzo Coglitore
 * ITP 265, FALL 2020, Coffee Section
 * Assignment XX, Week ##
 * Email: ecoglito@usc.edu
 */
public class Trainer extends Being {
	private double money;
	private char gender;
	private String team;
	private ArrayList<Badge> badges;
	// private ArrayList<Pokemon> myPokemons;
	/**
	 * @param name
	 * @param healthPoints
	 * @param region
	 */
	public Trainer(String name, int healthPoints, Region region, double money, char gender) {
		super(name, healthPoints, region);
		this.money = money;
		this.gender = gender;
		badges = new ArrayList<>();
		// TODO Auto-generated constructor stub
		
		
		
	}
	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}
	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}
	/**
	 * @return the badges
	 */
	public ArrayList<Badge> getBadges() {
		return badges;
	}
	
	
	
	

}
