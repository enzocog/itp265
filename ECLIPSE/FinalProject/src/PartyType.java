import model.ProductType;

public enum PartyType {
	POTLUCK,
	COSTUMEPARTY,
	HOLIDAYPARTY,
	BIRTHDAY,
	UKNOWN;
	
public static String makeProductTypeMenu() {
		
		String categoryMenu = "Choose a category to view items: ";
		for(int i = 1; i < PartyType.values().length; i++) {
			PartyType t = PartyType.values()[i];
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
	public static PartyType getProductType(int num) {
		return  PartyType.values()[num];
	}
	public static PartyType getProductType(String name) {
		PartyType match = UNKNOWN;
		for(PartyType t: PartyType.values()) {
			if(t.name().equalsIgnoreCase(name)) {
				match = t;
			}
		}
		return  match;
	}
}
