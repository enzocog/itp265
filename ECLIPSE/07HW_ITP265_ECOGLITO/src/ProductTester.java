import java.util.*;

/**
 * Write description of class here
 *
 * @author Kendra Walther
 * ITP 265, Section
 * Email: kwalther@usc.edu
 *
 */
public class ProductTester {

	private List<Product> allProducts;
	private UI sc;
	private ProductType productList;

	public ProductTester() {
		allProducts = StoreFactory.setUpStoreProducts();
		sc = new UI();
	}

	public static void main(String[] args) {
		System.out.println("PRODUCT TESTER");
		ProductTester store = new ProductTester();
		System.out.println("METHOD 1 -- All products in the store:");
		store.printProductPriceAndName();
		System.out.println("\nMETHOD 2 -- All products in the store, sorted by price");
		store.showItemsByPrice();
		System.out.println("\nMETHOD 3 --Inventory in the store by Product Type");
		store.showInventoryByCategory();
		System.out.println("\nMETHOD 4 --Rentable items:");
		store.showRentals();

		System.out.println("\nMETHOD 5 --All items (full to String)");
		store.showAll();

	}

	public void printProductPriceAndName() { //prints out price + name
		System.out.println("Implement method");
		//TODO -- can use friendly to help get the price of a given product p in a user-friendly format
		//String friendly = String.format("$%.2f", p.getPrice());
		for (int i = 0; i < allProducts.size(); i++) {
			System.out.println(allProducts.get(i).getName() + " " + String.format("$%.2f", allProducts.get(i).getPrice()));
			
		}
	}

	public void showInventoryByCategory() { //prints out by category
		for (int i = 0; i < ProductType.values().length; i++) {
			List<Product> test = getCategoryList(ProductType.getProductNumberedInt(i));
			for (int j = 0; j < test.size(); j++) {
				System.out.println(test.get(j));
			}
		}
	}

	private ArrayList<Product> getCategoryList(ProductType type) { //helper method
		ArrayList<Product> items = new ArrayList<>();
		for(Product p: allProducts) {
			if(p.getClass().getSimpleName().equalsIgnoreCase(type.toString())){
				items.add(p);
			}
		}
		return items;
	}


	private void showItemsByPrice() { //sort by price
		System.out.println("Implement method");
		Collections.sort(allProducts);
		for(int i = 0; i < allProducts.size(); i++){
			System.out.println(allProducts.get(i).getName() + " " + String.format("$%.2f", allProducts.get(i).getPrice()));
	    }	
	}


	private void showRentals() {

		for (Product p: allProducts) {
			if(p instanceof Rentable) {
				Rentable r = (Rentable) p;
				System.out.println( p.getName() + ": " +  String.format("$%.2f", r.getRentalPrice()));
			}
		}
		
	}
	
	private void showAll() { //show all
		for (int i = 0; i < allProducts.size(); i++ ) {
			System.out.println(allProducts.get(i).toString());
		}
	
	}
}