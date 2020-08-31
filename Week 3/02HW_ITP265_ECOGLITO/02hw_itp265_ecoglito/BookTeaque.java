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
{
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
    
    Scanner myScanner = new Scanner(System.in);
    
    public BookTeaque(){
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
    public void bookAdder(){
         
        
    } 
    public void shop(){
        boolean loopVar = true;
        printInventory();
        while (loopVar){
        System.out.println("Do you want to buy a book/beverage/checkout? (book, beverage, checkout)");
        String userChoice = myScanner.next();
            if (userChoice.equalsIgnoreCase("book")) {
                System.out.println("Awesome! Choose a book number between 1-5 (enter 1-5)");
                int userBookChoice = myScanner.nextInt();
                switch (userBookChoice) {
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
            }
            else if (userChoice.equalsIgnoreCase("beverage")) {
                System.out.println("Awesome! Choose a book number between 1-3 (enter 1-3)");
                int userBeverageChoice = myScanner.nextInt();
                switch (userBeverageChoice) {
                    case 1:
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
            }
            else if (userChoice.equalsIgnoreCase("checkout")) {
                System.out.println("Thank you for shopping at " + storeName + ". You bought: " + currentOrder + ".");
                loopVar = false;
               }
        }
    }
    
    public static void main(String[] args){
	BookTeaque myStore = new BookTeaque();
	myStore.shop();
}
   
}
