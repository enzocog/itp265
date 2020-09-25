
import java.util.*;
/**
 * Write a description of class AccomplishmentProgram here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class AccomplishmentProgram {
  private UI sc;
  private Accomplishment database[];
  private static final String fileName= "kaggle-datasets-firsts-TABBED.txt";
  private static final int DEFAULT_SIZE = 479;
  private int numSlotsFilled;
  
  public AccomplishmentProgram(){
    sc = new UI();
    database = new Accomplishment[DEFAULT_SIZE];
    numSlotsFilled = 0;
    }
  
  public void run() {
    Menu choice;

    do{
        Menu.print();
        int num = sc.inputInt("Which option>", 0, Menu.getNumberOfMenuItems());
        choice = Menu.getOption(num);
        switch(choice){
            case PRINT: printFacts(); break; //make this
            //case QUIZ:  playQuiz(); break;
            case FEMALE: printFemale(); break;
            case MALE: printMale(); break;
            case CATEGORY: printCategory(); break;
            case QUIT: System.out.println("Goodbye"); break;
        
       }
    
    }
    
    while(choice != Menu.QUIT);
    }


  public static void main(String[] args) {
        AccomplishmentProgram program = new AccomplishmentProgram();
        program.run();
    }
    
   
   
  public void readDataFromFile(String file){
    String[] fileData = sc.readFile(file);
    for(int i = 1; i < fileData.length; i++){
        String entry = fileData[i];
        Scanner entryScanner = new Scanner(entry);
        entryScanner.useDelimiter("\t"); 
        int year = entryScanner.nextInt();
        String accomplishment = entryScanner.next();
        String person = entryScanner.next();
        String gender = entryScanner.next();
        Boolean genderCheck = false;
        if (gender.contains("Female")){
        genderCheck = true;
        }
        String category = entryScanner.next();
        
        Category cat = Category.getCategoryFromDescription(category);
        Accomplishment c = new Accomplishment(year, accomplishment, person, genderCheck, cat);
        boolean added = addData(c);
    
        
    }
}
    private boolean addData(Accomplishment c){
        boolean addedData = false;
        if(numSlotsFilled < database.length) {
        database[numSlotsFilled] = c;
        numSlotsFilled++;
        addedData = true;
        }
        return addedData;
    }
    
    
    
    
   public void printFacts(){
    readDataFromFile(fileName);
    for (int i = 0; i < database.length; i++) {
    System.out.println(database[i]);
    }
    }

   public void playQuiz(){
    int score = 0;
    readDataFromFile(fileName);
    Random objGenerator = new Random();
    for (int i = 0; i< 10; i++){
              
              int randomNumber = objGenerator.nextInt(250);
              int x = sc.inputInt( "In what year did " + database[randomNumber].getPerson() + " become the " + database[randomNumber].getAccomplishment(), 1738, 2019);
              if (database[randomNumber].getYear() - x <= 5 || database[randomNumber].getYear() - x >= -5) {
                 score = score + 1;
                }
              else
                System.out.println("Sorry you were not within 5 years!");
                }
    }
    
    
    public void printFemale(){
    readDataFromFile(fileName);
    for (int i = 0; i < database.length; i++){
        if (database[i].isFemale()){
            System.out.println(database[i]);
        }
       
    }
    }
    
    public void printMale(){
    readDataFromFile(fileName);
    for (int i = 0; i < database.length; i++){
        if (!database[i].isFemale()){
            System.out.println(database[i]);
        }
       
    }
    
    }
    
    public void printCategory(){
    readDataFromFile(fileName);
    
    
    int userInput = sc.inputInt("Which category would you like to see?", 1, 8);
    Category.getCategoryOptions();
    switch(userInput){
    case 1: printCertainCategory("Social & Jobs"); break;
    case 2: printCertainCategory("Arts & Entertainment"); break;
    case 3: printCertainCategory("Religion"); break;
    case 4: printCertainCategory("Military"); break;
    case 5: printCertainCategory("Education & Science"); break;
    case 6: printCertainCategory("Law"); break;
    case 7: printCertainCategory("Politics"); break;
    case 8: printCertainCategory("Sports"); break;
    }
    }
   
    public void printCertainCategory(String x){
    for (int i = 0; i < database.length; i++){
        if (database[i].getCategory().toString().contains(x)){
            System.out.println(database[i]);
            
        }
       
    }
    
    }
} 