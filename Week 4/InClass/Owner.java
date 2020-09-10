
/**
 * Brief description of the class
 * @author Kendra Walther
 * email: kwalther@usc.edu
 * ITP 265
 * * In Class Activity, Week 3
 */
public class Owner {
	private String name;
	private double money;
	private Pet myPet;

	public Owner(String name, double money, Pet myPet) {
		this.name = name;
		this.money = money;
		this.myPet = myPet;
	}
	
		public Owner(String name, double money) {
		this(name, money, null);
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
	 * @return the myPet
	 */
	public Pet getMyPet() {
		return myPet;
	}

	/**
	 * @param myPet the myPet to set
	 */
	public void setMyPet(Pet myPet) {
		this.myPet = myPet;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public String toString() {
		String message = "Owner: " + name ;
		message += "\nMoney: " + money ;
		message += "\nPet: " + myPet ;
		return message;
		
	}
	
}
