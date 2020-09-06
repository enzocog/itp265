 import java.util.Scanner; //import scanner
/**
 * This provides book Teaque
 *
 * @author Enzo Coglitore
 * ITP 265, Term Year (Fall 2020), Class Session (Coffee)
 * Assignment 02
 * Email: ecoglito@usc.edu
 */
public class BookTeaque
{ //init variables
    private String storeName;
    private Book Book1;
    private Book Book2;
    private Book Book3;
    private Book Book4;
    private Book Book5;
    private Beverage Beverage1;
    private Beverage Beverage2;
    private Beverage Beverage3;
    private String currentOrder;
    private String userChoice;
    Scanner myScanner = new Scanner(System.in);
    
    public BookTeaque(){ //init the constructor with the new values
        this.storeName = "Enzo's store";
        this.currentOrder = "";
      
        Book1 = new Book("Lord of the Flies", "William Golding", 5.99, "Hardcover", 224);
        Book2 = new Book("Intelligent Investor", "Benjamin Graham", 14.29, "Hardcover", 640);
        Book3 = new Book("Kindred", "Ocatvia Butler", 10.49, "Hardcover", 264);
        Book4 = new Book("The Alchemist", "Paulo Coelho", 14.29, "Hardcover", 163);
        Book5 = new Book("Extreme Ownership", "Jocko Willink", 13.97, "Hardcover", 351);
        
        Beverage1 = new Beverage("Kombucha", 9.50);
        Beverage2 = new Beverage("Iced Coffee", 4.50);
        Beverage3 = new Beverage("Water", 2.50);
     
    }
    
    public void printInventory(){ //print inventory
        for (int i = 0; i <75; i++){
        System.out.print("*");
        };
        System.out.println();
        System.out.println("Welcome to: " + storeName);
        System.out.println();
        
        System.out.println("Here are our list of books:");
        System.out.println(Book1.toString());
        System.out.println(Book2.toString());
        System.out.println(Book3.toString());
        System.out.println(Book4.toString());
        System.out.println(Book5.toString());

        System.out.println();
        
        System.out.println("Here are our list of beverages:");
        System.out.println(Beverage1.toString());
        System.out.println(Beverage2.toString());
        System.out.println(Beverage3.toString());
        
        for (int i = 0; i <75; i++){
        System.out.print("*");
        };
        System.out.println();
    }
    
    public void shop(){ //create shop method
        boolean loopVar = true;
        printInventory(); //print inventory method
        while (loopVar){
        System.out.println("Do you want to buy a book/beverage/checkout? (book, beverage, checkout)");
        userChoice = myScanner.next(); // ask for user choice
            if (userChoice.equalsIgnoreCase("book")) { //if book then execute below
                System.out.println("Awesome! Choose a book number between 1-5 (enter 1-5)");   
                myScanner.nextLine();
                boolean userBookChoiceBool = true;
                while (userBookChoiceBool) {
                if (myScanner.hasNextInt()){ //if input has an int,
                    int userBookChoice = myScanner.nextInt(); //ask for their book choi
                        if (userBookChoice <= 5 && userBookChoice >= 1) {
                        currentOrder =  bookChecker(userBookChoice); //call bookChecker helper method to see if in range
                        userBookChoiceBool = false;
                        }
                        else{
                        System.out.println("You are not in the valid range [1-5]"); //tell them they out of range
                        }
                  }  
                else {
                myScanner.nextLine();
                System.out.println("That was not a number!"); //tell them their input was bad
                 }
               } 
            }  
            else if (userChoice.equalsIgnoreCase("beverage")) { //same methodology for beverage
                System.out.println("Awesome! Choose a book number between 1-3 (enter 1-3)");
                myScanner.nextLine(); //clear
                boolean userBeverageChoiceBool = true;
                while (userBeverageChoiceBool) { //while this loop is true
                if (myScanner.hasNextInt()){ //check if int
                    int userBeverageChoice = myScanner.nextInt(); //ask for input
                    if (userBeverageChoice <= 3 && userBeverageChoice >= 1) { //if it is
                    currentOrder = beverageChecker(userBeverageChoice); //run our switch/case
                    userBeverageChoiceBool = false;
                    }
                    else { //print invalid range
                        System.out.println("You are not in the valid range [1-3]");
                    }
            }
            else { //print invalid input
                myScanner.nextLine();
                System.out.println("That was not a number!"); //tell them their input was bad
                 }
        }
        }
            else if (userChoice.equalsIgnoreCase("checkout")) { //print values at checkout
                System.out.println("Thank you for shopping at " + storeName + ". You bought: " + currentOrder);
                loopVar = false;
            }
            else {
                System.out.println("This choice has not been recognized as book, beverage, or checkout");
            }
        }
    }
    
    public String bookChecker(int userBookChoice){ //check for their int input
         switch (userBookChoice) { //case statement for book
                    case 1:
                        System.out.println("You purchased book1!");
                        currentOrder = currentOrder + "book1 ";
                        break;
                    case 2:
                        System.out.println("You purchased book2!");
                        currentOrder = currentOrder + "book2 ";
                        break;
                    case 3:
                        System.out.println("You purchased book3!");
                        currentOrder = currentOrder + "book3 ";
                        break;
                    case 4:
                        System.out.println("You purchased book4!");
                        currentOrder = currentOrder + "book4 ";
                        break;
                    case 5:
                        System.out.println("You purchased book5!");
                        currentOrder = currentOrder + "book5 ";
                        break;
                }
        return currentOrder;
    } 
    
    public String beverageChecker(int userBeverageChoice){ //check for their int input for beverage 
        switch (userBeverageChoice) { 
                    case 1: //case statement for books
                        System.out.println("You purchased beverage1!");
                        currentOrder = currentOrder + "beverage1 ";
                        break;
                    case 2:
                        System.out.println("You purchased beverage2!");
                        currentOrder = currentOrder + "beverage2 ";
                        break;
                    case 3:
                        System.out.println("You purchased beverage3!");
                        currentOrder = currentOrder + "beverage3 ";
                        break;
                }
        return currentOrder;
    }
    
    public static void main(String[] args){ //run main command
    BookTeaque myStore = new BookTeaque();
    myStore.shop();
}
   
}
