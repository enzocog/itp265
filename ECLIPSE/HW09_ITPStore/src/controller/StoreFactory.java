package controller;
/**
 * Write description of class here
 *
 * @author Kendra Walther
 * ITP 265
 * STORE HOMEWORK, Starter code
 * Email: kwalther@usc.edu
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import model.*;


public class StoreFactory {
	private static final String PRODUCT_FILE = "src/products.csv";
	private static final String STREAMABLE_FILE = "src/streamable.csv";


	/**
	 * Reads the two files to make a MAPS of all the store products
	 * @return the map of Products, organized by ProductType
	 */
	public static Map<ProductType, List<Product>> setUpStoreMap(){
		Map<ProductType, List<Product>> map = new HashMap<>(20);
		// setting up my map keys. USE producttype enum to set up the keys. 
		for(ProductType type: ProductType.values()) { //each item in enum becomes a map key
			map.put(type, new ArrayList<Product>() ) ; // each type pairs with an empty list
		}
		readFile(PRODUCT_FILE, map);
		readFile(STREAMABLE_FILE, map);

		return map;

	}

	// method is an example: overload. same method name, different signature
	private static void readFile(String file, Map<ProductType, List<Product>> myMap) {
		try(FileInputStream fis = new FileInputStream(file);
				Scanner scan = new Scanner(fis))
		{  // NOTE: resources will be closed automatically with this try block
			if (scan.hasNext()) {
				String header = scan.nextLine();
				while(scan.hasNextLine()) {
					String line = scan.nextLine();
					Product p = parseStringIntoProduct(line);
					// Product from the file -- add it to the map under the correct category
					if(p != null) { // if the line was corrupted
						
						ProductType myType = ProductType.getProductType(p.getClass().getSimpleName());
						if(myMap.containsKey(myType)) {
							List<Product> list = myMap.get(myType);
							list.add(p);
						}
						else { // no items of that type yet.
							List<Product> list = new ArrayList<Product>();
							list.add(p);
							myMap.put(myType, list);
						}
					}
				}
			}
			else {
				System.err.println("File was empty: " + file);
			}
		}

		catch (FileNotFoundException e) {
			System.err.println("File not found: " + file);
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 


	}


	/**
	 * Reads the two files to make a LIST of all the store products
	 * @return the list of Products
	 */
	public static List<Product> setUpStoreProducts() {
		List<Product> allProducts = new ArrayList<>();
		readFile(PRODUCT_FILE, allProducts);
		readFile(STREAMABLE_FILE, allProducts);
		return allProducts;
	}

	/**
	 * @param productFile
	 * @return
	 */
	private static void readFile(String file, List<Product> list) {
		try(FileInputStream fis = new FileInputStream(file);
				Scanner scan = new Scanner(fis))
		{  // NOTE: resources will be closed automatically with this try block
			if (scan.hasNext()) {
				String header = scan.nextLine();
				while(scan.hasNextLine()) {
					String line = scan.nextLine();
					Product p = parseStringIntoProduct(line);
					if(p != null) {
						list.add(p);
					}
				}
			}
			else {
				System.err.println("File was empty: " + file);
			}
		}

		catch (FileNotFoundException e) {
			System.err.println("File not found: " + file);
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 


	}

	/**
	 * @param line
	 * @return
	 */
	private static Product parseStringIntoProduct(String line) {
		//CSV format:
		//Product Type,Name,Price,Rating,Item or Streamable,Item quantity,Streamable duration,withPrime,releaseYear,Other Data
		Product product = null;
		try {

			Scanner sc = new Scanner(line);
			sc.useDelimiter(",");
			String type = sc.next();
			String rest = sc.nextLine();
			if(type.equalsIgnoreCase("Item")) {
				product = parseItem(rest);
			}
			else if(type.equalsIgnoreCase("Streamable")) {
				product = parseStreamable(rest);

			}else {
				System.err.println("Unknown category in file: " + type);
			}

		}
		catch(Exception e) {
			System.err.println("Error reading line of file: " + line + "\nerror; " + e);
		}
		return product;
	}


	private static StreamableProduct parseStreamable(String line) {
		StreamableProduct thing = null;
		try {
			Scanner sc = new Scanner(line);
			sc.useDelimiter(",");
			String productType = sc.next();
			String name = sc.next();
			double price = sc.nextDouble();
			double rating = sc.nextDouble();
			double duration = sc.nextDouble();
			boolean withPrime = sc.nextBoolean();
			String releaseYear = sc.next(); 
			String otherData = sc.nextLine();
			if(productType.equalsIgnoreCase("Music")) {
				MusicGenre genre = parseMusicGenre(otherData);
				thing = new Music(name, price, rating, duration, withPrime, releaseYear, genre);
			}
			else if(productType.equalsIgnoreCase("Video")) {
				Genre genre = parseVideoGenre(otherData);
				thing = new Video(name, price, rating, duration, withPrime, releaseYear, genre);
			}

		}
		catch(Exception e) {
			System.err.println("Error reading line of file: " + line + "\nerror; " + e);
		}
		return thing;
	}

	/**
	 * @param otherData
	 * @return
	 */
	private static Genre parseVideoGenre(String otherData) {
		Genre genre = Genre.ACTION;
		for(Genre gen: Genre.values()) {
			if(gen.toString().equalsIgnoreCase(otherData)) {
				genre = gen;
				break; // found match
			}
		}
		return genre;
	}

	/**
	 * @param otherData
	 * @return
	 */
	private static MusicGenre parseMusicGenre(String otherData) {
		MusicGenre genre = MusicGenre.POP;
		for(MusicGenre gen: MusicGenre.values()) {
			if(gen.toString().equalsIgnoreCase(otherData)) {
				genre = gen;
				break; // found match
			}
		}
		return genre;
	}

	/**
	 * @param nextLine
	 * @return
	 */
	private static Item parseItem(String line) {
		Item item = null;
		try {
			Scanner sc = new Scanner(line);
			sc.useDelimiter(",");
			String productType = sc.next();
			String name = sc.next();
			double price = sc.nextDouble();
			double rating = sc.nextDouble();
			int quantity = sc.nextInt();
			// get otherData column(s)
			if(productType.equalsIgnoreCase("Book")) {
				String genre =  sc.next();
				int numPages =  sc.nextInt();
				item = new Book(name, price, rating, quantity, genre, numPages);
			}
			else if(productType.equalsIgnoreCase("Electronic")) {
				String dim =  sc.next();
				String weight= sc.next();
				item = new Electronics(name, price, rating, quantity,dim, weight);
			}		
			else if(productType.equalsIgnoreCase("Games")) {
				String otherData = sc.next();
				item = new Games(name, price, rating, quantity,otherData);
			}	
		}
		catch(Exception e) {
			System.err.println("Error reading line of file: " + line + "\nerror; " + e);
			e.printStackTrace();
		}
		return item;
	}

}
