import java.util.*;

/**
 * Write a description of class Bakery here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bakery
{
	// instance variables - replace the example below with your own
	private ArrayList<Cupcake> allCupcakes;
	private UI ui;

	/**
	 * Constructor for objects of class Bakery
	 */
	public Bakery()
	{
		//initialize the instance variables
		//for list (arraylist) is 10 default ok or not?
		allCupcakes = new ArrayList<>( 25); // start my list at a better capacity (efficiency)
		ui = new UI();
	}

	public void makeStartingInventory(){
		Cupcake c = new Cupcake(Cake.CHOCOLATE, Frosting.CHOCOLATE, true);
		makeCupcakes(c, 12);
		makeCupcakes(new Cupcake(Cake.RED_VELVET, Frosting.CREAM_CHEESE, true), 10);
		makeCupcakes(new Cupcake(Cake.VANILLA, Frosting.BUTTERCREAM, true), 12);
		makeCupcakes(new Cupcake(Cake.CHOCOLATE, Frosting.BUTTERCREAM, true), 12);
	}

	private void makeCupcakes(Cupcake type, int num){
		for(int i = 0; i < num; i++){
			allCupcakes.add(type);
		}
	}

	public void printTrayOfCupcakes() {
		int numRows = 3; //total size for the array
		int numCols = 4;
		Cupcake[][] tray  = new Cupcake[numRows][numCols]; //row col order


		//print tray (12 null spots)
		//make a for loop that goes through the array
		for(int row = 0; row < tray.length;row++) { //tray.length is the number of rows in the 2d array called tray (row: 0,1,2,3
			for(int col = 0; col < tray[row].length; col++) { // the # of columns in the row
				System.out.print(row + "," + col + ":" + " is empty\t");

			}
			System.out.println();
		}



		tray[0][0] = allCupcakes.remove(0);
		tray[0][1] = allCupcakes.remove(0);
		tray[0][2] = allCupcakes.remove(0);
		tray[0][3] = allCupcakes.remove(0);
		
		System.out.println("Filled one row of the tray....");
		for(int row = 0; row < tray.length;row++) { //tray.length is the number of rows in the 2d array called tray (row: 0,1,2,3
			for(int col = 0; col < tray[row].length; col++) { // the # of columns in the row
				if(tray[row][col] == null) {
					System.out.print("__");
					}
				else { //spot has a cupcake
					System.out.print(Cupcake.CUPCAKE_ICON);
				}
				
				System.out.print("\t");

			}
			System.out.println();
		}


	}

	public void makeCupcakes(){
		do{
			Cake cake = Cake.UNKNOWN; // local variable for cake
			do{
				String cakeString = ui.inputLine("What type of cake will you use?");
				cake = Cake.findMatchingCake(cakeString);
				if(cake == Cake.UNKNOWN){
					System.out.println("Not a recognized cake type");
					Cake.printOptions();
				}
			}while(cake == Cake.UNKNOWN);

			Frosting frosting = Frosting.BUTTERCREAM;//ui.inputLine("What frosting goes on the " + cake + " cake?");
			boolean sprinkles = ui.inputYesNo("Do you want to add sprinkles? (y/n)");
			int num = ui.inputInt("How many of those would you like to make?", 1, 48);

			Cupcake c = new Cupcake(cake, frosting, sprinkles);
			makeCupcakes(c, num);
		}while(ui.inputYesNo("Want to make more cupcakes? (y/n)"));
	}

	public void findCake(){
		String cakeString = ui.inputLine("What type of cake would you like?");
		Cake cake = Cake.findMatchingCake(cakeString);
		//error checking... 
		ArrayList<Cupcake> matching = new ArrayList<>();
		for(Cupcake c: allCupcakes){
			if(c.getCakeType() == cake){ //now its a enum use ==
				matching.add(c);
			}
		}
		if(matching.size() == 0){
			System.out.println("No cupcakes of that type");
		}
		else{
			System.out.println("Here is what we have in stock:");
			for(int i = 1; i <= matching.size(); i++){
				System.out.println(i + ":" + matching.get(i-1));
			}

			ArrayList<Cupcake> order = new ArrayList<Cupcake>(); //empty order of cucpakes
			do{

				int i = ui.inputInt("Which cupcake would you like to buy?", 1, matching.size());
				Cupcake c = matching.get(i-1); // get the cupcake
				//TODO: REMOVE FROM BAKERY
				order.add(c);
			}while(ui.inputYesNo("Would you like to purchase more?"));

			System.out.println("Your order is " + order);
			// how do we make them LEAVE the bakery.....
		}
	}

	public void printItems(){
		for(Cupcake c: allCupcakes){
			ui.print(c.toString());
		}
	}

}
