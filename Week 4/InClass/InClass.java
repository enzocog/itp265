import java.util.Scanner;
/**
 * Write a description of class InClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InClass{
    private String months[] = new String[] {
    "January", "Feburary", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"};
    //make days array
    private int days[] = new int[12];
    private Scanner myScanner = new Scanner(System.in);
    
    
    
    public void main() { //main method
    
    //set days list to amount of days in month
    days[0] = 31;
    days[1] = 28;
    days[2] = 31;
    days[3] = 30;
    days[4] = 31;
    days[5] = 30;
    days[6] = 31;
    days[7] = 31;
    days[8] = 31;
    days[9] = 31;
    days[10] = 30;
    days[11] = 31;  
    
    for (int i = 0; i<12; i++) {
        System.out.println(months[i] + " has "  + days[i] + " days.");
    }
    System.out.println(userInputString(userInputChecker("Please enter a month number.", 1, 12)));

 
    }
    
    public int userInputChecker(String prompt, int min, int max) { //check if input is in range
    int userInput = inputIntChecker(prompt);
    while (userInput < min || userInput > max) {
        System.out.println(userInput + " is not in the allowed range, " + min + " - " + max);
        userInput = inputIntChecker(prompt);
    }
    return userInput;
    }
    
  public int inputIntChecker(String prompt) { //check if input is an int
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
    
   public String userInputString(int userInput) { //return variable that prints out the month + days
   String userMonth = (months[userInput - 1] + " has " + days[userInput - 1] + " days.");
    
    return userMonth; 
}
    
    
}


