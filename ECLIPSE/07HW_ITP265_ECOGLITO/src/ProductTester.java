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
		store.showAll(); // this should really be the first thing the students do.

	}

	public void printProductPriceAndName() {
		System.out.println("Implement method");
		//TODO -- can use friendly to help get the price of a given product p in a user-friendly format
		//String friendly = String.format("$%.2f", p.getPrice());
		for (int i = 0; i < allProducts.size(); i++) {
			System.out.println(allProducts.get(i).getName() + " " + String.format("$%.2f", allProducts.get(i).getPrice()));
			
		}
	}

	public void showInventoryByCategory() {
		//productList.getCategoryOptions();
		for (int i = 0; i < productList.values().length; i++) {
			System.out.println(getCategoryList(productList));
		}
		// Loop through enum of all ProductTypes 
		// Use private helper method getCategoryList to return a list of Products matching that type

		// if there are no Products of the given type in the list, print "\tNo matching items"
		// otherwise print the list contents, one per line with a tab followed by the product's toString result

		//TODO
	}

	private ArrayList<Product> getCategoryList(ProductType type) {
		ArrayList<Product> items = new ArrayList<>();
		for(Product p: allProducts) {
			if(p.getClass().getSimpleName().equalsIgnoreCase(type.toString())){
				items.add(p);
			}
		}
		return items;
	}


	private void showItemsByPrice() {
		System.out.println("Implement method");
		Collections.sort(allProducts);
		for(int i = 0; i < allProducts.size(); i++){
	        System.out.println("Product: " + allProducts.get(i).getName() + " Price: " + allProducts.get(i).getPrice());
	    }	//TODO
	}


	private void showRentals() {
		System.out.println("Implement method");
		for (int i = 0; i < allProducts.size(); i++) {
			if (allProducts.get(i))
			
			
		}
		//TODO
	}
	
	private void showAll() {
		System.out.println("Implement method");
		for (int i = 0; i < allProducts.size(); i++ ) {
			System.out.println(allProducts.get(i).toString());
		}
	
	}
}