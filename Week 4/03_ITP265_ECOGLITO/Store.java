import java.util.Scanner; //import scanner
/**
 * This allows users to see our books/beverages and buy them
 *
 * @author Enzo Coglitore
 * ITP 265, Term Year (Fall 2020), Class Session (Coffee)
 * Assignment 02
 * Email: ecoglito@usc.edu
 */
public class Store
{ //init variables
    private String storeName;
    private CreditCard CreditCard1;
    private Scanner myScanner;
    
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

    
    public Store(){
    myScanner = new Scanner(System.in);
    this.storeName = "Enzo's store";
    makeUser();
    
    Book1 = new Book("Lord of the Flies", "William Golding", 5.99, "Hardcover", 224);
    Book2 = new Book("Intelligent Investor", "Benjamin Graham", 14.29, "Hardcover", 640);
    Book3 = new Book("Kindred", "Ocatvia Butler", 10.49, "Hardcover", 264);
    Book4 = new Book("The Alchemist", "Paulo Coelho", 14.29, "Hardcover", 163);
    Book5 = new Book("Extreme Ownership", "Jocko Willink", 13.97, "Hardcover", 351);
    
    Beverage1 = new Beverage("Kombucha", 9.50);
    Beverage2 = new Beverage("Iced Coffee", 4.50);
    Beverage3 = new Beverage("Water", 2.50);
    
    
    }
        
    private void makeUser() {
        
        System.out.println("Before you can get to the store, we need you to make a credit card!");
        System.out.println("What is your name?");
        String cName = myScanner.nextLine();
        System.out.println("What is your zip code?");
        int czipCode = myScanner.nextInt();
        System.out.println("Enter your credit card number (16 digits w/ spaces)");
        myScanner.nextLine();
        String cNumber = myScanner.nextLine();
        System.out.println("Enter your security code (3 digits)");
        int csecurityCode = myScanner.nextInt();
        System.out.println("Enter your expiration date");
        myScanner.nextLine();
        String cexpirationDate = myScanner.nextLine();
        CreditCard1 = new CreditCard(cName, czipCode, cNumber, cexpirationDate, csecurityCode, 500.0);
        
    }
        
    
    
    public void printInventory(){ //print inventory
        for (int i = 0; i <75; i++){
        System.out.print("*");
        };
        System.out.println();
        System.out.println("Welcome to: " + storeName);
        System.out.println();
        
        System.out.println("Here is your credit card:");
        System.out.println(CreditCard1.toString());
        
        System.out.println();
        System.out.println("Here is our list of books:");
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
    
    public int bookInputRangeChecker(String prompt, int min, int max){ //check if input is in allowed range
        int num = bookInputIntChecker(prompt);
        while(num < min || num > max){
            System.out.println(num + " is not in the allowed range, " + min + " - " + max);
            num = bookInputIntChecker(prompt);
        }
        return num;
    }
    
    public int bookInputIntChecker(String prompt) { //check if input is an int
        System.out.println(prompt);
        
        while(myScanner.hasNextInt() == false) {
        String garbage = myScanner.nextLine();
        System.out.println(garbage + " was not an int.");
        System.out.println(prompt);
        }
        
        int i = myScanner.nextInt();
        myScanner.nextLine();
        return i;
    
    }
    
    public String bookChecker(int userBookChoice){ //check for their int input and add to current order
     switch (userBookChoice) { //case statement for book
                case 1:
                    System.out.println("You purchased book1!");
                    currentOrder = currentOrder + "book1 ";
                    double newBalance = Book1.getPrice();
                    CreditCard1.setBalance(newBalance);
                    System.out.println(CreditCard1.getBalance());
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
    
     public int beverageInputRangeChecker(String prompt, int min, int max){ //check if bevInput is in range
        int num = beverageInputIntChecker(prompt);
        while(num < min || num > max){
            System.out.println(num + " is not in the allowed range, " + min + " - " + max);
            num = beverageInputIntChecker(prompt);
        }
        return num;
    }
    
    public int beverageInputIntChecker(String prompt) { //check if bevInput is an int
        System.out.println(prompt);
        
        while(myScanner.hasNextInt() == false) {
        String garbage = myScanner.nextLine();
        System.out.println(garbage + " was not an int.");
        System.out.println(prompt);
        }
        
        int i = myScanner.nextInt();
        myScanner.nextLine();
        return i;
    
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
    
    public void shop(){ //create shop method
        boolean loopVar = true;
        printInventory(); //print inventory method
        while (loopVar){
        System.out.println("Do you want to buy a book/beverage/checkout? (book, beverage, checkout)");
        userChoice = myScanner.next(); // ask for user choice
            if (userChoice.equalsIgnoreCase("book")) { //if book then execute below
                String n = myScanner.nextLine(); //clear garbage
                bookChecker(bookInputRangeChecker("Please choose a number between 1-5!", 1, 5)); //run all methods
            }  
            else if (userChoice.equalsIgnoreCase("beverage")) { //same methodology for beverage
                String n = myScanner.nextLine(); //clear garbage
                beverageChecker(beverageInputRangeChecker("Please choose a number between 1-3!", 1, 3)); //run all methods
        }
            else if (userChoice.equalsIgnoreCase("checkout")) { //print values at checkout
                System.out.println("Thank you for shopping at " + storeName + ". You bought: " + currentOrder);
                System.out.println("Your new balance is:" + CreditCard1.getBalance());//print checkout
                loopVar = false; //end loop
            }
            else { //error handle for userInput choice
                System.out.println("This choice has not been recognized as book, beverage, or checkout");
            }
        }
    }
    
    
    public static void main(String[] args){ //run main command
    Store myStore = new Store();
    myStore.shop();
}
   
}
