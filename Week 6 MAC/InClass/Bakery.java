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
    
    public void makeCupcakes(){
        do{
            String cake = ui.inputLine("What type of cake will you use?");
             String frosting = ui.inputLine("What frosting goes on the " + cake + " cake?");
          boolean sprinkles = ui.inputYesNo("Do you want to add sprinkles? (y/n)");
          Cupcake c = new Cupcake(cake, frosting, sprinkles);
          allCupcakes.add(c);
        }
        while(ui.inputYesNo("Want to make more cupcakes? (y/n)"));
    } 
    
    public void printItems(){
        for(Cupcake c: allCupcakes){
            ui.print(c.toString());
        }
    }
    
    public void makeStartingInventory(){
        Cupcake c = new Cupcake("Chocolate", "Chocolate", true);
        makeCupcakes(c, 12);
        makeCupcakes(new Cupcake("Red Velvet", "Cream Cheese", true), 10);
        makeCupcakes(new Cupcake("Vanilla", "Buttercream", true), 12);
        makeCupcakes(new Cupcake("Chocolate", "Vanilla Buttercream", true), 12);
    }

    private void makeCupcakes(Cupcake type, int num){
        for(int i = 0; i < num; i++){
            allCupcakes.add(type);
        }
    }

    
    public void findCake(){
    makeStartingInventory();
    int num = 0;
    String x = ui.inputWord("Please enter the cake flavor you would like to search");
    for (int i = 0; i < allCupcakes.size(); i++) {
     if (allCupcakes.get(i).getCake().equalsIgnoreCase(x)){
        num ++;
        System.out.println(num + ": " + allCupcakes.get(i));
        }
    }
    
    
    }

}
