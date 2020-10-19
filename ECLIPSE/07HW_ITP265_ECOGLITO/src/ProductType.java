/**
 * 
 * 
 * @author This is the product type enum
 * Enzo Coglitore
 * ITP 265, Coffee
 * HW 07
 * Ecoglito@usc.edu
 *
 */
public enum ProductType {
	BOOK,
	GAMES,
	ELECTRONICS,
	VIDEO,
	MUSIC,
	TOYS,
	APPLIANCES;
	
	
	public static void getCategoryOptions(){
	    for(int i = 1; i < ProductType.values().length; i++){
	            String x = ProductType.values()[i-1].toString();
	            System.out.println(i + ":" + x);
	        }
	    }
	
	public static ProductType getProductNumberedInt(int num) {
		return ProductType.values()[num];
		
	}
	
	
}
