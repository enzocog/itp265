import java.util.*;
/**
 * 
 * @author Kendra Walther
 * email: kwalther@usc.edu
 * ITP 265
 * In Class Activity, Week 3
 */
public class CyberPet {

    private Owner user;
    private Pet[] allPets;
    private Scanner sc;

    private static double STARTING_MONEY = 5.00;
    private static double ADOPTION_FEE = 2.99;

    public CyberPet() {
    sc = new Scanner(System.in);
        initializePets();
        makeUser();

    }

    /**
     * 
     */
    private void initializePets() {
        allPets = new Pet[5];
        // could load animals from a file, or manually create in code
        // For ease, we will manually create the animals here. File reading
        // will be added later in the semester
        //ARRAY syntax will be covered soon
        allPets[0] = new Pet("Ollie", "Bunny", 5);
        allPets[1] = new Pet("Murdock","French Bulldog", 3);
        allPets[2] = new Pet("Ptolemy","Cat", 1);
        allPets[3] = new Pet("Peewee","Turtle", 10);
        allPets[4] = new Pet("Milo","Labrador", 5);
    }

    public void printPets() {
        for(int i = 0; i< allPets.length; i++) {
            System.out.println( (i+1) + ")" + allPets[i].getNameSpecies());
        }
    }
    private Pet choosePet() {
        int num = 0;
        System.out.println("Choose your pet from the following: ");
        System.out.println("*******************************");
        printPets();
        System.out.println("*******************************");
        int choice = -1;

        //TODO: Get the user's choice of animales
        // "Please select an animal from the list > " 
        // animals are numbered; 1 to allPets.length

        Pet selected = allPets[0]; //update to actual choice
        return selected;

    }

    private void makeUser() {
        //TODO: get User's name
        System.out.println("What is your name?");
        String userName = sc.nextLine();
        
        
        Pet p = choosePet(); //get User pet
        
        //TODO: construct the user object (calling new Object) and default starting money
        
        user = new Owner(userName, STARTING_MONEY, p);

    }

    public void displayMenu() {
        String menu = "-----------------------------" +
                "\n1) Play\n2) Feed\n3) Give Medicine"
                +"\n4) Sleep\n5) Print your Pet's stats"+
                "\n6) Rename your pet\n7) See your profile"+
                "\n8) View All Pets\n9) Exchange pet\n10) Exit"
                + "\n-----------------------------" ;
        System.out.println(menu);

    }
    
    public int isInt(String prompt){
        System.out.print(prompt);
        
        while(!sc.hasNextInt()){
            String garbage = sc.nextLine();
            System.out.println(garbage + " was not an int.");
            System.out.println(prompt);
        }
        
        int i = sc.nextInt();
        sc.nextLine();
        return i;
    }
    
    public int isInRange(String prompt, int min, int max) {
        int num = isInt(prompt);
        while (num < min || num > max) {
            System.out.println(num + " is not in the allowed range, " + min + " - " + max + ".");
            num = isInt(prompt);
        }
        return num;
    
    }
    

    public void run() {
        System.out.println("Welcome to the CyberPet program! What would you like to do?");
        int option = 0;
        while (option != 10) {
            
             System.out.println("This method will be in an infinite loop until you finish the todo");
            displayMenu();
            //TODO: get a valid option selection 
            option = isInRange("Please make a selection> ", 1, 10); 
        
            if (option >= 1 && option <= 6) {
                doPetAction(option);
            }
            else if(option == 7) {
                System.out.println(user);
            }
            else if(option == 8) {
                printPets();
            }
            else if(option == 9) {
                Pet p = choosePet();
                Pet current = user.getMyPet();
                if(! p.equals(current)) {
                    System.out.println("Replacing: " + current.getNameSpecies() + 
                            " with " + p.getNameSpecies());
                    user.setMyPet(p);
                }
                else {
                    System.out.println("That is already your pet.");
                }
            }
            else if(option == 10) {
                System.out.println("Goodbye");
            }
            
        }
    }

    /**
     * @param option
     */
    private void doPetAction(int choice) {
        Pet animal = user.getMyPet();
        

        switch(choice) {
        case 1:
            animal.play();
            System.out.println("You played with " + animal.getNameSpecies() + "!");
            break;

        case 2:
            animal.feed();
            System.out.println("You fed " + animal.getNameSpecies() + "!");
            break;
        case 3:
            animal.giveMedicine();
            System.out.println("You gave medicine to  " + animal.getNameSpecies() + "!");
            break;
        case 4:
            animal.sleep();
            System.out.println("Shhhh. " + animal.getNameSpecies() + "  is taking a nap");
            break;
        case 5:
            System.out.println(animal);
            break;
        case 6:
            
             String newName ="Michael"; 
            animal.setPetName(newName);
            System.out.println("Your pet has been renamed:  " + animal.getNameSpecies());
            break;
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        CyberPet program = new CyberPet();
        program.run();

    }

}
