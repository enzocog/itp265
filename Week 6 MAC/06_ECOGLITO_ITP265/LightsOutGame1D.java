import java.util.*;
/**
 * Lets you control flow of game and sets up array of light objects
 *
 * Enzo Coglitore
 * ecoglito@usc.edu
 * ITP265
 */
public class LightsOutGame1D
{
   private Light database[];
   private UI sc;
   private int numSpots;
   
   
   public LightsOutGame1D(){
    sc = new UI();
    numSpots = sc.inputInt("Please enter how many lights you want to play with! (3-15)", 3, 15);
    database = new Light[numSpots];
    
    for (int i = 0; i < database.length; i++) {   
        database[i] = new Light(getRandomBoolean()); 
    }
    printLights();
    }
    
    public void printLights(){
    for(int i = 0; i < database.length; i++) {
        System.out.print(database[i].isOn());
    }
    System.out.println();
    for (int i = 0; i < database.length; i++) {
        System.out.print((i+1) + " ");
    }
    
    }
    
    public static boolean getRandomBoolean(){
        return Math.random() < 0.5;
    }
    
    public void playGame() {
    System.out.println("Welcome to the Lights Out Game!");
    System.out.println("The objective of this game is to turn off all the lights. When you turn a light on/off, the lights surrounding it will correspond!");
    System.out.println(database.length);
    boolean checkLightsBool = false;
    
    while(checkLightsBool == false){
    printLights();
    System.out.println();
    
    int userInput = sc.inputInt("Please choose a light (number) to turn on/off! (0 to quit)", 0, database.length);
    
    if (userInput == 0) {
        System.out.println("Better luck nextime!");
        break;
    }
    changeLights(userInput);
    checkLightsBool = checkLights();
    }
    System.out.println("The game is over!");
    }
    
    private void changeLights(int userInput) {
    if (userInput == 1){
        database[userInput-1].flip();
        database[userInput].flip();
    }
    else if (userInput == database.length){
        database[userInput-1].flip();
        database[userInput-2].flip();
    }
    else {
        database[userInput-2].flip();
        database[userInput-1].flip();
        database[userInput].flip();
     }   
    
    }
    
    private boolean checkLights(){
        int numCorrect = 0;
        for (int i = 0; i < database.length; i++) {
            if (database[i].isLightOn() == false) {
                numCorrect ++;
            }
        }
        if (numCorrect == database.length){
            return true;
        }
        else {
            return false;
        }
    }

}