
import java.util.*;
/**
 * This runs the program by calling in various classes, enums, and methods.
 *
 * Enzo Coglitore
 * ITP 265, Coffee, Ecoglito@usc.edu
 */

public class AccomplishmentProgram { //init data
  private UI sc;
  private Accomplishment database[];
  private static final String fileName= "kaggle-datasets-firsts-TABBED.txt";
  private static final int DEFAULT_SIZE = 479;
  private int numSlotsFilled;

  
  public AccomplishmentProgram(){ //define + init class vars
    sc = new UI();
    database = new Accomplishment[DEFAULT_SIZE];

    numSlotsFilled = 0;
    }
  public void displayWelcome() { //welcome
        String intro = "This data is from Kaggle's Tidy Tuesday Week 24 and comes from Wikipedia. It is a celebration of "
                +"Black Lives,\n\ttheir achievements, and many of their battles against racism across their lives."
                + "\n\tThis is in emphasis that Black Lives Matter and we're focusing on a celebration of these lives. ";

        String info = "The firsts.csv dataset has 479 records of African-Americans breaking the color "
                +"barrier across a \n\twide range of topics. The raw text has been adapted from Wikipedia to "
                + " highlight:\n\t** The year of the event\n\t** The role/action/topic"
                + "\n\t** The person or people involved\n\t** Addition of gender\n\t** A category of topics";
        
        //NOTE: the gender data does not all look to be correct in this data set.
        
        String citation = "Original data set can be found here: https://www.kaggle.com/jessemostipak/african-american-achievements/";

	System.out.println("INTRO: \n\t" + intro + "\n\nINFO: \n\t" + info + "\n\n" + citation);
	}
    	
  public void run() { //run menu
    Menu choice; 

    do{
        System.out.println("*****	Menu	*****");
        Menu.print();
        System.out.println("**********************************************");
        int num = sc.inputInt("Choose > ", 0, Menu.getNumberOfMenuItems());
        choice = Menu.getOption(num);
        switch(choice){
            case PRINT: printFacts(); break; //make this
            case QUIZ:  playQuiz(); break;
            case FEMALE: printFemale(); break;
            case MALE: printMale(); break;
            case CATEGORY: printCategory(); break;
            case QUIT: System.out.println("Goodbye."); break;
        
       }
    
    }
    
    while(choice != Menu.QUIT);
    }


  public static void main(String[] args) { //main run program
        AccomplishmentProgram program = new AccomplishmentProgram();
        program.displayWelcome();
        program.run();
    }
    
   
   
  public void readDataFromFile(String file){ //read data + put into list!
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
    private boolean addData(Accomplishment c){ //add the data to list if its not full
        boolean addedData = false;
        if(numSlotsFilled < database.length) {
        database[numSlotsFilled] = c;
        numSlotsFilled++;
        addedData = true;
        }
        return addedData;
    }
    
    
    
    
   public void printFacts(){ //print all facts
    readDataFromFile(fileName);
    for (int i = 0; i < database.length; i++) {
    System.out.println(database[i]);
    }
    }

   public void playQuiz(){ //play a simple quiz
    int score = 0;
    readDataFromFile(fileName);
    Random objGenerator = new Random();
    for (int i = 0; i< 10; i++){
              int randomNumber = objGenerator.nextInt(DEFAULT_SIZE);
              int x = sc.inputInt( "In what year did " + database[randomNumber].getPerson() + " become the " + database[randomNumber].getAccomplishment()+ "? (5 year range)", 1738, 2019);
              if ((database[randomNumber].getYear() - x) <= 5 && (x - database[randomNumber].getYear()) >= -5) {
                 score = score + 1;
                 System.out.println("That was correct!");
                 System.out.println("Your score is now: " + score); 
                }
              else
                System.out.println("Sorry you were not within 5 years!");
                System.out.println("The correct answer was: " + database[randomNumber].getYear());
                System.out.println("Your score is now: " + score);
                }
    System.out.println("Thanks for playing! Your final score was: " + score);
    }
    
    
    public void printFemale(){ //print out females
    readDataFromFile(fileName);
    for (int i = 0; i < database.length; i++){
        if (database[i].isFemale()){
            System.out.println(database[i]);
        }
       
    }
    }
    
    public void printMale(){ //print males
    readDataFromFile(fileName);
    for (int i = 0; i < database.length; i++){
        if (!database[i].isFemale()){
            System.out.println(database[i]);
        }
       
    }
    
    }
    
    public void printCategory(){ //print out the categories
    readDataFromFile(fileName);
    Category.getCategoryOptions();

    int userInput = sc.inputInt("Which category would you like to see?", 1, 8);
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
   
    public void printCertainCategory(String x){ //print a certain category
    for (int i = 0; i < database.length; i++){
        if (database[i].getCategory().toString().contains(x)){
            System.out.println(database[i]);
            
        }
       
    }
    
    }
} 