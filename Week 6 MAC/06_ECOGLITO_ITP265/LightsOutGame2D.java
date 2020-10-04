

/**
 * Write a description of class LightsOutGame2D here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LightsOutGame2D
{
   private Light database[][];
   private UI sc;
   private int numSpots;
   private String[] alphabet = {"A", "B", "C", "D", "E"};
   
   
   public LightsOutGame2D(){
    sc = new UI();
    numSpots = sc.inputInt("What size board do you want to play with? (3-5)", 3, 5);
    database = new Light[numSpots][numSpots];

    
    for (int i = 0; i < numSpots; i++) {
        for (int j = 0; j < numSpots; j++) {
        database[i][j] = new Light(getRandomBoolean()); 
        }
    }
    printLights();
    }
    
    public void printLights(){
    for (int i = 0; i < database.length; i++){
        System.out.print(" ");
        System.out.print(alphabet[i] + "\t");
    }
    System.out.println();
    int x = 0;
    for (Light[] a : database) {
        x++;
        System.out.print(x);
        for (Light i : a) {
            System.out.print(i.isOn() + "\t");
        }
        System.out.println("\n");
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
    
    int rowInput = sc.inputInt("Please choose a row! (0 to quit)", 0, database.length);
    String colLetter = sc.inputWord("Please enter the column letter of the light:");
    int colInput = 0;
    if (colLetter.equalsIgnoreCase("A")){
        colInput = 0;
    }
    else if (colLetter.equalsIgnoreCase("B")){
        colInput = 1;
    }
    else if (colLetter.equalsIgnoreCase("C")){
        colInput = 2;
    }
    else if (colLetter.equalsIgnoreCase("C")){
        colInput = 3;
    }
    else if (colLetter.equalsIgnoreCase("C")){
        colInput = 4;
    }
    
    int targetRow;
    int targetCol;
    
    //case1
    targetRow = rowInput;
    targetCol = colInput;
    if (checkPosition(targetRow, targetCol)) {
      changeLights(targetRow, targetCol);
    }
    
    targetRow = rowInput -1;
    targetCol = colInput;
    if (checkPosition(targetRow, targetCol)) {
      changeLights(targetRow, targetCol);
    }
    
    targetRow = rowInput + 1;
    targetCol = colInput;
    if (checkPosition(targetRow, targetCol)) {
      changeLights(targetRow, targetCol);
    }
    
    
    targetRow = rowInput;
    targetCol = colInput + 1;
    if (checkPosition(targetRow, targetCol)) {
      changeLights(targetRow, targetCol);
    }
    
    targetRow = rowInput;
    targetCol = colInput - 1;
    if (checkPosition(targetRow, targetCol)) {
      changeLights(targetRow, targetCol);
    }
    
    
    if (rowInput == 0) {
        System.out.println("Better luck nextime!");
        break;
    }
    changeLights(rowInput, colInput);
    checkLightsBool = checkLights();
    }
    System.out.println("The game is over!");
    }

    private boolean checkPosition(int targetRow, int targetCol){
    if (targetRow >= 0 && targetRow <= database.length && targetCol >= 0 && targetCol < numSpots) {
        return true;
    }
    return false;
    
    }
    private void changeLights(int rowInput, int colInput) {
        database[rowInput][colInput].flip();
    }
    
    private boolean checkLights(){
        int numCorrect = 0;
        for (int i = 0; i < database.length; i++) {
            for (int j = 0; j < database[i].length; j++)
            if (database[i][j].isLightOn() == false) {
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
 