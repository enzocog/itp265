package controller;
import model.*;
import view.*;
import java.util.*;
import java.util.Map.Entry;


public class ITPStore {

	private Map<ProductType, List<Product>> productMap;
	private Map<String, Customer> customers;

	private UI helper; 

	private Customer currentCustomer;
	private Customer guestAccount;

	private Map<Integer, Map<Product, Integer>> fulfilledOrders;

	private static int KEY = 100;
private static final double TAX_PERCENT = .0925;
	
	public ITPStore() {
		productMap = StoreFactory.setUpStoreMap();
		// helper = new UIPopUp(); //ideally we would be able to easily switch between JOptionPane and Console based output, but the
								// setup is not quite right for this one yet.
		helper = new UIConsole();

		guestAccount = new Customer("Guest Account", "tempAccount@fake.com");
		currentCustomer = guestAccount;

		customers = new HashMap<>();
		fulfilledOrders = new HashMap<>();
	}


	public void run() {
		boolean doneShopping = false;
		while(!doneShopping) {
			StoreMenu menuItem = getMenuItem();
			switch(menuItem) {
			case LOG_IN:
				login();
				break;
			case LOG_OUT:
				logout();
				currentCustomer = guestAccount; //reset to guest
				break;
			case SHOP_ALL:
				shopAllProducts();
				break;
			case SHOP_BY_CATEGORY:
				shopByCategory();
				break;
			case VIEW_CART:
				viewShoppingCart();
				break;
			case CHECKOUT:
				checkout();
				break;
			case SHOW_STORE_STATS:
				showStoreStats();
				break;
			case QUIT: 
				doneShopping = true;
				break;
			} //end switch
			
		}// done Shopping loop
		saveSystemState();
		helper.print("Goodbye. Amazon shutting down for the day.\nThank you for shopping!");
	}

	/**
	 * Prints the current customer and then displays the menu of options and allows the user
	 * to select one.
	 * @return
	 */
	private StoreMenu getMenuItem() {
		helper.print("* " + currentCustomer.getName() + " is logged in *");

		String menu = StoreMenu.getMenuOptions();
		int input = helper.inputInt(menu, 0, StoreMenu.getNumOptions() -1);

		return  StoreMenu.getOption(input);

	}


	/**
	 * This method allows user to shop all products in the store. Asks if the products should be sorted by price
	 */
	private void shopAllProducts() {
		List<Product> list = getListOfAllProducts();
		displayList("All products in the store", list);
	}

	/**
	 * This method allows user to shop the store by Category. 
	 */
	private void shopByCategory() {
		ProductType type = selectCategory();
		List<Product> list = getCategoryList(type);
		displayList("Items that match category: " + type, list);
	}


	/**
	 * Given a header to describe the list and a list of products, display all the items and give the customer an option
	 * to buy something
	 * @param header: What should be displayed above the list
	 * @param list: A list of products
	 */
	private void displayList(String header, List<Product> list) {

		if(! list.isEmpty()) {
			boolean sort = helper.inputYesNoAsBoolean("Would you like products sorted by price? (y/n)");
			if(sort) {
				Collections.sort(list);
			}

			String s = header + "\n";
			for(Product p : list) {
				s += "\t" + p + "\n";
			}

			s+= "Would you like to buy an item from this list (y/n)?  >> ";
			boolean buy = helper.inputYesNoAsBoolean(s);
			if(buy) {
				buyProductFromList(list);
			}
		}
	}




	private ProductType selectCategory() {

		System.out.println(ProductType.makeProductTypeMenu());

		int categoryOption = helper.inputInt("Category #", 1,
				ProductType.values().length);

		ProductType type = (ProductType.values()[categoryOption]);
		return type;


	}

	private List<Product> getListOfAllProducts(){
		Collection<List<Product>> c = productMap.values();

		List<Product> masterList = new ArrayList<>();
		for(List<Product> list : c) {
			masterList.addAll(list);
		}
		return masterList;
	}


	public void showStoreStats() {
		System.out.println("Fulfilled " + fulfilledOrders.size() + " orders so far:");
		for(Integer key: fulfilledOrders.keySet()) {
			Map<Product, Integer> cart = fulfilledOrders.get(key);
			System.out.println("\tOrder: " + key + " with " + cart.size() + " distinct products");
			for(Entry<Product, Integer> pairing : cart.entrySet()) {
				System.out.println("\t\t" + pairing.getValue() + " of " + pairing.getKey());
			}
		}
	}

	/**
	 * 
	 */
	private void saveSystemState() {
		//TODO: finish this so that we save to a file
		System.out.println("Fulfilled " + fulfilledOrders.size() + " orders today:");
		for(Integer key: fulfilledOrders.keySet()) {
			Map<Product, Integer> cart = fulfilledOrders.get(key);
			System.out.println("\tOrder: " + key + " with " + cart.size() + " distinct products");
		}
		System.out.println("Saving state not currently implemented. In the future, write to csv files to reflect what was purchased in store.");
	}



	public void displayInventoryByCategory(boolean sort) {
		String display = "";
		for(ProductType type: ProductType.values()) {
			if(type != ProductType.UNKNOWN) { // skip unknown category
				display += type + "\n";
				List<Product> items = getCategoryList(type);
				Collections.sort(items);
				if(items.isEmpty()) {
					display += "\tNo matching items\n";
				}
				else {
					if(sort) {
						Collections.sort(items);
					}
					for(Product p: items) {
						display += ("\t" + p + "\n");
					}
				}
			}
		}
		helper.print(display);
	}


	private List<Product> getCategoryList(ProductType type) {
		return productMap.get(type);

	}


	private void login() {
		helper.print("Welcome to my Amazon-like store!");

		String word = helper.inputWord("Would you like to sign in to your account or create a new account?\n" +
				"Type: \"signin\" or \"create\"", "signin", "create");
		if (word.equalsIgnoreCase("signin")) {
			signin();
		}
		else {
			createAccount();
		}
	}
	private void createAccount() {
		String email =  helper.inputLine("Please give me your email:");
		if(customers.containsKey(email)) {
			boolean signIn = helper.inputYesNoAsBoolean("There already exists a customer with that email. Signin instead? (y/n)?");
			if(signIn) {
				signin(email);
			}
			else {
				helper.print("Continuing as a guest");
				currentCustomer = guestAccount;
			}
		}
		else {
			createAccount(email);
		}
	}
	private void createAccount(String email) {
		//only gets called when there is no account associated with that email
		String name = helper.inputWord("Please enter the name to associate with account");
		Map<Product, Integer> cart = currentCustomer.getCart();
		Customer c = null;
		if(cart.isEmpty()) {
			c  = new Customer(name, email);
		}
		else {
			int numProducts = cart.size();

			boolean copyCart = helper.inputYesNoAsBoolean("Would you like to copy over the current guest shopping cart with " 
					+ numProducts +" items?\n>");
			if(copyCart) {
				Map<Product,Integer> cartCopy = new HashMap<>(cart);
				c = new Customer(name, email, cartCopy);
			}
			else {
				c  = new Customer(name, email);
			}
		}
		customers.put(email, c);
		currentCustomer = c;

	}
	private void signin(String email) {
		if(customers.containsKey(email)) {
			currentCustomer = customers.get(email);
			helper.print("Welcome back " + currentCustomer.getName());
			checkItemsInCart();
		}
		else {
			boolean createNew = helper.inputYesNoAsBoolean("Didn't find customer with that email. Would you like to create an account? (y/n)");
			if(createNew) {
				createAccount(email);
			}
			else {
				helper.print("Continuing as a guest");
				currentCustomer = guestAccount;
			}	

		}
	}
	/**
	 * 
	 */
	private void checkItemsInCart() {
		//TODO : if a customer logged in, their cart might not be accurate
		System.out.println("Guest account: " + guestAccount.cartToString());
		Map<Product,Integer> cartCopy = new HashMap<>(guestAccount.getCart());

		System.out.println("Current customer cart: " + currentCustomer.cartToString());
		System.out.println("Should ask to combine or pick cart contents to keep and update items in cart.... Not yet implemented");
	}


	private void signin() {
		String email =  helper.inputLine("Please \"login\" by giving me your email:");
		signin(email);
	}

	private void logout() {
		Customer c = currentCustomer;
		currentCustomer = guestAccount;
		currentCustomer.emptyCart();
		helper.print("Logged " + c.getName() + " out of Amazon store");

	}



	/**
	 * Given a LIST of products, let's the user select one by number to purchase
	 * @param products
	 */
	private void buyProductFromList(List<Product> products) {
		if(products.isEmpty()) {
			helper.print("No items currently available for purchase");
			return; // EXIT immediately from the method
		}
		// if there are products to buy, let the customer shop
		do {
			String options = "Select product to buy:\n";
			//Get a nicely formatted list of products by number.
			for(int i = 0; i < products.size(); i++) {
				Product p = products.get(i);
				String item = String.format("%d: $%.2f : %s (%s) \n", i, p.getPrice(),  p.getName(), p.getClass().getSimpleName());
				options += item ;
			}

			int itemNum = helper.inputInt(options + "\nChoose item # (or -1 to exit this menu) >>> ", 0, products.size()-1, -1);
			if(itemNum != -1) {
				Product p = products.get(itemNum);
				buyProduct(p);
			}
		}while(helper.inputYesNoAsBoolean("Would you like to purchase something else from this list?(y/n)"));



	}


	/**
	 * Adds the item to the customer's cart.
	 * @param p
	 */

	private void buyProduct(Product p) {
		helper.inputYesNoAsBoolean("You have selected: " + p + "\nType \"y\" to add this to cart, \"n\" if you don't wish to purchase: ");
		if(p instanceof Item) {
			Item i = (Item)p;
			if(i.getQuantity() > 0) {
				addToCart(i, getQuantityDesired(i));
			}
			else {
				helper.print("sorry item is sold out");
			}
		}
		else if (p instanceof StreamableProduct) {
			addToCart(p,1);
		}

	}


	/**
	 * @return
	 */
	private int getQuantityDesired(Item item) {
		int qty = item.getQuantity();
		System.out.println("There are " + item.getQuantity() + " items currently available.");

		int numProducts = helper.inputInt("How many " + item.getName() + " would you like?", 1, item.getQuantity());
		//update inventory of item
		item.removeInventory(numProducts);

		return numProducts;
	}




	private void addToCart(Product p, int numProducts) {
		currentCustomer.addProductToCart(p, numProducts);
		helper.print(p.getName() + " has been added to your cart");

	}

	private void showRentals() {
		List<Product> tempList = getListOfAllProducts();
		for(Product p: tempList) {
			if(p instanceof Rentable) {
				double price = ((Rentable) p).getRentalPrice();
				System.out.println("(Rent from : $" + String.format("%.2f", price) + ") - " + p.getName());
			}
		}

	}

	private void viewShoppingCart() {
		helper.print(currentCustomer.cartToString());

	}

	/*
	 * TODO: Provide description of what this method does
	 */
	private void checkout() {
		if (currentCustomer == guestAccount) {
			helper.print("You are shopping as a guest. \nPlease login or create an account to place order");
			login();
		}
		else {
			Map<Product, Integer> shoppingCart = currentCustomer.getCart();
			helper.print("Thank you for shopping with us, " + currentCustomer.getName());
			String receipt = "PURCHASE SUMMARY\n" + currentCustomer.cartToString();
			double cost =  calculateTotal(); 
			receipt += ("\n** Subtotal amount is: $" + String.format("%.2f",cost));
			//NOTE: probably should only charge shipping and handling for items, not streamable products
			double shipping = getShippingCost(shoppingCart);
			receipt += "\n Shipping and Handling $" + String.format("%.2f", shipping);
			double tax = cost*TAX_PERCENT;
			receipt += "\n Sales Tax $" + String.format("%.2f", tax);
			receipt += "\n Total is $" + String.format("%.2f", (cost+tax+shipping));
			helper.print(receipt + "\n\nYour order has been placed!");
			KEY++;

			fulfilledOrders.put(KEY, new HashMap<>(shoppingCart));
			currentCustomer.emptyCart();

			helper.print("Your order ID is: " + KEY);
		}
	}




	private double getShippingCost(Map<Product, Integer> shoppingCart) {
		double cost = 0; // assume no shipping
		for(Product p: shoppingCart.keySet()) {
			if(p instanceof Item) { // if we have any Item subclasses, shipping is 4.99
				cost = 4.99;
			}
		}
		return cost;
	}


	/**
	 * @return
	 */
	private double calculateTotal() {
		/*Note: for a real customer, would have to check if they were prime
		members, to not charge for items that are free with prime */
		double total = 0.0;
		Map<Product, Integer> shoppingCart = currentCustomer.getCart();
		for(Product p: shoppingCart.keySet()) {
			double cost = p.getPrice();
			if(p instanceof StreamableProduct)	{			
				if(((StreamableProduct)p).isIncludedWithPrime() 
						&& currentCustomer.isPrimeMember()) {
					cost = 0;
				}
			}
			else{	// streamable can't have multiples
				int num = shoppingCart.get(p);
				cost = num * cost;
			}
			total += cost;

		}
		return total;
	}

	/*
	 * TODO: Provide description of what this method does
	 */
	public void printMenu() {
		System.out.println("\nMain Menu");
		System.out.println("1 : View Items by Category");
		System.out.println("2 : View Shopping Cart");
		System.out.println("3 : Checkout");
		System.out.println("4 : Quit");
	}

	public void showInventory() {
		for(ProductType type: ProductType.values()) {
			System.out.println(type);
			List<Product> items = getCategoryList(type);
			Collections.sort(items);
			if(items.isEmpty()) {
				System.out.println("\tNo matching items");
			}
			else {
				for(Product p: items) {
					System.out.println("\t" + p);
				}
			}
		}
	}

	/*
	 * TODO: Provide description of what this method does
	 */
	public static void main(String[] args) {
		ITPStore store = new ITPStore();

		store.run();
	}

}
