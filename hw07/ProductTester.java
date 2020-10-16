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

	public ProductTester() {
		allProducts = StoreFactory.setUpStoreProducts();
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
			System.out.println(allProducts.get(i).getName() + String.format("$%.2f", allProducts.get(i).getPrice()));
			
		}
	}

	public void showInventoryByCategory() {
		System.out.println("Implement method");
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
		// sort the profuct list and print product price and name
		//TODO
	}


	private void showRentals() {
		System.out.println("Implement method");
		// loop through all the products and see if a given product is Rentable
		// print each rentable product in the form, with rental price and name of product
		//(Rent from : $0.00) - Psych

		//TODO
	}
	
	private void showAll() {
		System.out.println("Implement method");
	
	}
}