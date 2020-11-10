package controller;

/**
 * Write description of class here
 *
 * @author Kendra Walther
 * ITP 265
 * Email: kwalther@usc.edu
 *
 */
public enum StoreMenu {
	LOG_IN("Login as current customer"),
	CREATE_ACCOUNT("Create a new customer account"),
	LOG_OUT("Log out current customer"),
	SHOP_ALL("Browse store (shop list of all items)"),
	SHOP_BY_CATEGORY("Shop store (shop for items based on category)"),
	VIEW_CART("View Customer Shopping Cart"),
	CHECKOUT("Checkout"),
	SHOW_STORE_STATS("Show back-end store details"),
	QUIT("Quit");
	
	private String description;
	private StoreMenu(String description){
		this.description = description;
	}
	
	public String getDisplayString(){
		return this.description;
	}
	public static int getNumOptions() {
		return StoreMenu.values().length;
	}
	
	public static StoreMenu getOption(int num) {
		return StoreMenu.values()[num];
	}
	public static String getMenuOptions() {
		String prompt = "*****\tITP STORE Main Menu\t*****";

		for(StoreMenu m : StoreMenu.values()){ //array from the enum
			prompt += "\n" + (m.ordinal()) + ": " + m.getDisplayString();
		}
		prompt+="\n**********************************************\n";
		return prompt;
	}
}
