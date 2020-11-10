package model;
/**
 * Write description of class here
 *
 * @author Kendra Walther
 * ITP 265
 * STORE HOMEWORK, Starter code
 * Email: kwalther@usc.edu
 *
 */
public enum ProductType {
	UNKNOWN,
	BOOK,
	GAMES,
	ELECTRONICS,
	VIDEO, 
	MUSIC, 
	TOYS,
	APPLIANCES;
	
	public static String makeProductTypeMenu() {
		
		String categoryMenu = "Choose a category to view items: ";
		for(int i = 1; i < ProductType.values().length; i++) {
			ProductType t = ProductType.values()[i];
			categoryMenu += "\n" + i 
					+ ": " + t.name();
			
		}
		return categoryMenu;
		
	}
	/** 
	 * 
	 * @param num (Indexed starting at 1)
	 * @return
	 */
	public static ProductType getProductType(int num) {
		return  ProductType.values()[num];
	}
	public static ProductType getProductType(String name) {
		ProductType match = UNKNOWN;
		for(ProductType t: ProductType.values()) {
			if(t.name().equalsIgnoreCase(name)) {
				match = t;
			}
		}
		return  match;
	}
}
